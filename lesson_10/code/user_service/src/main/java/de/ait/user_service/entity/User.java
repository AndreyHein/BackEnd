package de.ait.user_service.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
@Getter                                 // можно указать для конкретного поля
@ToString
@EqualsAndHashCode (of = {"id", "email"})
// @EqualsAndHashCode (exclude = {"id", "email"})
@Builder                                // User nick = User.builder().id(3l).name("nick").build();
@Setter
public class User {
    @Setter
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
