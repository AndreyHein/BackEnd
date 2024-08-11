package de.ait.user_service.repository;

import de.ait.user_service.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    List<User> list = List.of(
            new User(1L, "Jack", "jack@gmail.com", "qwer1"),
            new User(2L, "John", "john@gmail.com", "qwer2"),
            new User(3L, "Anna", "anna@gmail.com", "qwer3"),
            new User(5L, "Jack", "jack@gmail.com", "qwer5"),
            new User(4L, "Lena", "lena@gmail.com", "qwer4"));


    @Override
    public List<User> findAll() {
        return list;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }
}
