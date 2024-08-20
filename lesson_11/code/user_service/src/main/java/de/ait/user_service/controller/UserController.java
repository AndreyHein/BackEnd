package de.ait.user_service.controller;

import de.ait.user_service.dto.UserCreateDto;
import de.ait.user_service.dto.UserResponseDto;
import de.ait.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    // "api/users"  GET
    // "api/users?name=jack
    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers(@RequestParam(name = "name", required = false, defaultValue = "") String name) {
        if (name.equals("")) {
            return service.getAll();
        } else {
            return service.getByName(name);
        }
    }

    // "/api/users/2"
    @GetMapping("/users/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserCreateDto user) {
        return service.create(user);
    }

    @DeleteMapping("/users/{id}")
    public UserResponseDto delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserCreateDto userCreateDto) {
        return service.update(id, userCreateDto);
    }
}
