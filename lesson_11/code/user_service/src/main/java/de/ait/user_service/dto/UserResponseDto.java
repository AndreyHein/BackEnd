package de.ait.user_service.dto;

import de.ait.user_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }

    public static List<UserResponseDto> of(List<User> listEntity) {
        return listEntity.stream()
                .map(UserResponseDto::of)
                .toList();
    }
}

