package com.kepco.etax.api.domain.request.login;


import com.kepco.etax.api.domain.entity.EtaxUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtaxUserSignupRequest {

    private String username;
    private String email;
    private String password;
    private String name;
    private String nickName;
    private String provider;

    public EtaxUser toEntity(PasswordEncoder passwordEncoder) {
        return EtaxUser.builder()
            .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickName(nickName)
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }

    public EtaxUser toEntity() {
        return EtaxUser.builder()
                 .username(username)
                .email(email)
                .nickName(nickName)
                .name(name)
                .provider(provider)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}
