package de.ait_tr.demo20240807.repository;

import de.ait_tr.demo20240807.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private List<User> list = List.of(
            new User("jack", "jack@mail.com"),
            new User("anna", "anna@mail.com"),
            new User("nick", "nick@mail.com"),
            new User("lena", "lena@mail.com"));

    @Override
    public List<User> findAll() {
        return list;
    }
}