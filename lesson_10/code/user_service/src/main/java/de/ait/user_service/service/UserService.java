package de.ait.user_service.service;

import de.ait.user_service.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public List<User> getByName(String name);
    public User getUserById(Long id);
    public User save(User user);
    public User delete(Long id);
    public User update(User user);
}
