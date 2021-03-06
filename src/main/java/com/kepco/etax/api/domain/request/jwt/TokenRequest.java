package com.kepco.etax.api.domain.request.jwt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TokenRequest {
    String accessToken;
    String refreshToken;

    @Builder
    public TokenRequest(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}

