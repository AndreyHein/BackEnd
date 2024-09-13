package de.ait.shop42.security.sec_controller;

import de.ait.shop42.security.accounting.user.dto.UserLoginDto;
import de.ait.shop42.security.sec_dto.RefreshRequestDto;
import de.ait.shop42.security.sec_dto.TokenResponseDto;
import de.ait.shop42.security.sec_services.AuthService;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody UserLoginDto user) {
        try {
            return authService.login(user);
        } catch (AuthException e) {
            return new TokenResponseDto(null, null);
        }
    }

    @PostMapping("/refresh")
    public TokenResponseDto getNewAccessToken(@RequestBody RefreshRequestDto refreshRequestDto) {
        return authService.getNewAccessToken(refreshRequestDto.getRefreshToken());
    }
}
