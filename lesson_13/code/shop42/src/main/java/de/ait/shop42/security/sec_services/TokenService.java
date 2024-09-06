package de.ait.shop42.security.sec_services;

import de.ait.shop42.security.accounting.role.repository.RoleRepository;
import de.ait.shop42.security.accounting.user.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenService {
    private SecretKey accessKey;
    private SecretKey refreshKey;
    private RoleRepository roleRepository;

    @Value("${access.token.days}")
    private int accessTokenDays = 7;
    @Value("${refresh.token.days}")
    private int refreshTokenDays = 30;

    public TokenService(@Value("${key.access}") String accessSecret,
                        @Value("${key.refresh}")String refreshSecret,
                        @Autowired RoleRepository roleRepository) {
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecret));
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecret));
        this.roleRepository = roleRepository;
    }

    public String generateAccessToken(User user) {
        Date expirationDate = calcExpirationDate(accessTokenDays);
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .claim("roles", user.getAuthorities())
                .claim("name", user.getUsername())
                .signWith(accessKey)
                .compact();
    }

    public String generateRefreshToken(User user) {
        Date expirationDate = calcExpirationDate(refreshTokenDays);
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .signWith(refreshKey)
                .compact();
    }

    private Date calcExpirationDate(int days) {
        LocalDateTime current = LocalDateTime.now();
        Instant instant = current.plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        return Date.from(instant);
    }
}
