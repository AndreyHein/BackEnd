package de.home.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
}
