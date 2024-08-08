package de.ait_tr.demo20240807.service;

import de.ait_tr.demo20240807.entity.User;
import de.ait_tr.demo20240807.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
