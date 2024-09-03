package de.ait.shop42.security.accounting.role.service;

import de.ait.shop42.exception.RoleNotFoundException;
import de.ait.shop42.security.accounting.role.entity.Role;
import de.ait.shop42.security.accounting.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public Role getRoleByTitle(String title) {
        return repository.findByTitle(title).orElseThrow(() -> new RoleNotFoundException("No role found with title: " + title));
    }
}
