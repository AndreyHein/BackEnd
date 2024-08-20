package de.ait.user_service.service;

import de.ait.user_service.dto.UserCreateDto;
import de.ait.user_service.dto.UserResponseDto;
import de.ait.user_service.entity.User;

import java.util.List;

public interface UserService {
    public List<UserResponseDto> getAll();
    public List<UserResponseDto> getByName(String name);
    public UserResponseDto getById(Long id);
    public UserResponseDto create(UserCreateDto user);
    public UserResponseDto delete(Long id);
    public UserResponseDto update(Long id, UserCreateDto user);
}
