package de.ait.user_service.service;

import de.ait.user_service.entity.User;
import de.ait.user_service.exeption.UserNotFoundException;
import de.ait.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public List<User> getByName(String name) {
        return getAll()
                .stream()
                .filter(user -> user.getName()
                .equals(name))
                .toList();
    }

    @Override
    public User getUserById(Long id) {
        return getAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny().orElseThrow(()-> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = getUserById(id);
        if (user != null) {
            return repository.delete(user);
        } else {
            return null;
        }
    }
}
