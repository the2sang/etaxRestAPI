package com.kepco.etax.api.domain.request.login;


import com.kepco.etax.api.domain.entity.EtaxUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EtaxUserLoginRequest {
    private String username;
    private String password;

    public EtaxUser toUser(PasswordEncoder passwordEncoder) {
        return EtaxUser.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
