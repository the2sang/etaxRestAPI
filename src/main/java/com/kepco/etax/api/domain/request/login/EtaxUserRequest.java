package com.kepco.etax.api.domain.request.login;


import com.kepco.etax.api.domain.entity.EtaxUser;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtaxUserRequest {

    private String email;
    private String name;
    private String nickName;

    public EtaxUser toEntity() {
        return EtaxUser.builder()
                .email(email)
                .name(name)
                .nickName(nickName)
                .build();
    }
}

