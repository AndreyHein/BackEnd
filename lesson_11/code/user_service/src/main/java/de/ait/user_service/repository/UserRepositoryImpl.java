package de.ait.user_service.repository;

import de.ait.user_service.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> list = new ArrayList<>(List.of(
            new User(1L, "Jack", "jack@gmail.com", "qwer1"),
            new User(2L, "John", "john@gmail.com", "qwer2"),
            new User(3L, "Anna", "anna@gmail.com", "qwer3"),
            new User(5L, "Jack", "jack@gmail.com", "qwer5"),
            new User(4L, "Lena", "lena@gmail.com", "qwer4")));


    @Override
    public List<User> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public User save(User entity) {
        if (entity.getId() == null) {
            return create(entity);
        } else {
            return update(entity);
        }
    }

    private User update(User entity) {
        User user = list.stream()
                .filter(u -> u.getId().equals(entity.getId()))
                .findAny()
                .orElse(null);
        if (user != null) {
            user.setName(entity.getName());
            user.setEmail(entity.getEmail());
            user.setPassword(entity.getPassword());
        }
        return user;
    }
    private User create(User entity) {
        long max = list.stream().mapToLong(u -> u.getId().longValue())
                .max().getAsLong();
        entity.setId(max + 1);
        list.add(entity);
        return entity;
    }
    @Override
    public User delete(Long id) {
        User entity = findById(id);
        list.remove(entity);
        return entity;
    }

    @Override
    public User findById(Long id) {
        return list.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
