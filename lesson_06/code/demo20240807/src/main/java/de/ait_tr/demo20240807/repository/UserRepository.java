package de.ait_tr.demo20240807.repository;

import de.ait_tr.demo20240807.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
}
