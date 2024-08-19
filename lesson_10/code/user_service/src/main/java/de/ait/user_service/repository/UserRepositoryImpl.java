package de.ait.user_service.repository;

import de.ait.user_service.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

//@Repository
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
        long max = list.stream().mapToLong(u -> u.getId().longValue())
                .max().getAsLong();
        entity.setId(max + 1);
        list.add(entity);
        return entity;
    }

    @Override
    public User delete(User entity) {
        list.remove(entity);
        return entity;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
