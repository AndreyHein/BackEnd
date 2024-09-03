package de.ait.shop42.security.accounting.user.dto;

import de.ait.shop42.security.accounting.role.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Set<RoleDto> roles;
}
