package de.ait.user_service.service;

import de.ait.user_service.dto.UserCreateDto;
import de.ait.user_service.dto.UserResponseDto;
import de.ait.user_service.entity.User;
import de.ait.user_service.exception.UserNotFoundException;
import de.ait.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(@Qualifier("actualRepository") UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return UserResponseDto.of(repository.findAll());
    }

    @Override
    public List<UserResponseDto> getByName(String name) {
        return getAll()
                .stream()
                .filter(user -> user.getName()
                .equals(name))
                .toList();
    }

    @Override
    public UserResponseDto getById(Long id) {
        return getAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny().orElseThrow(()-> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public UserResponseDto create(UserCreateDto userDto) {
        User newUser = new User(null, userDto.getName(), userDto.getEmail(), userDto.getPassword());
        return UserResponseDto.of(repository.save(newUser));
    }

    @Override
    public UserResponseDto delete(Long id) {
        UserResponseDto user = getById(id);
        if (user != null) {
            return UserResponseDto.of(repository.delete(id));
        } else {
            return null;
        }
    }

    @Override
    public UserResponseDto update(Long id, UserCreateDto dtoUser) {
        User user = new User(id, dtoUser.getName(), dtoUser.getEmail(), dtoUser.getPassword());
        return UserResponseDto.of(repository.save(user));
    }
}
