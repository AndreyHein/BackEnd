package de.ait.shop42.security.accounting.role.repository;

import de.ait.shop42.security.accounting.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByTitle(String title);
}
