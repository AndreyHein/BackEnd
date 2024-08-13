package de.ait.user_service.repository;

import de.ait.user_service.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User save (User entity);
    User delete(User entity);
}
