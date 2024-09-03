package de.ait.shop42.security.accounting.user.service;

import de.ait.shop42.security.accounting.user.dto.UserRequestDto;
import de.ait.shop42.security.accounting.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createNewUser(UserRequestDto dto);
    List<UserResponseDto> getUsers();
    UserResponseDto setRoleAdmin(String username);
}
