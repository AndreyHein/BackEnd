package de.ait.shop42.security.accounting.user.repository;

import de.ait.shop42.security.accounting.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByName(String name);
}
