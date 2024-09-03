package de.ait.shop42.security.accounting.role.service;

import de.ait.shop42.security.accounting.role.entity.Role;

public interface RoleService {
    Role getRoleByTitle(String title);
}
