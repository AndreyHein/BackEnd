package de.ait.shop42.security.accounting.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    @Size(min = 3, max = 35)
    @Pattern(regexp = "^\\p{Lu}\\p{L}*")
    private String name;
    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]+$", message = "Should be strong")
    private String password;

    //@NotNull
    //NotEntity - поле коллекция или строка не должна быть пустой
}
