package de.ait.shop42.security.accounting.user.controller;

import de.ait.shop42.security.accounting.user.dto.UserRequestDto;
import de.ait.shop42.security.accounting.user.dto.UserResponseDto;
import de.ait.shop42.security.accounting.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/users")
public class UserController {

    private final UserService service;
    @PostMapping("/users")
    public UserResponseDto createNewUser(@RequestBody UserRequestDto dto) {
        return service.createNewUser(dto);
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return service.getUsers();
    }

    @PutMapping("/users/{username}/roles/admin")
    public UserResponseDto setRoleAdmin(String username) {
        return null;
    }
}
