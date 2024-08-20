package de.ait.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UserCreateDto {
    private String name;
    private String email;
    private String password;


}
