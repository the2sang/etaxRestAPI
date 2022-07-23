package com.kepco.etax.api.domain.entity.security;


import com.kepco.etax.api.domain.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "refresh_token")
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "REFRESH_TOKEN_SEQ_GENERATOR"
        , sequenceName = "REFRESH_TOKEN_SEQ"
        , initialValue = 2
        , allocationSize = 1
)
public class RefreshToken extends BaseTimeEntity {

    @Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,//사용할전략을 시퀀스로 선택
            generator="REFRESH_TOKEN_SEQ_GENERATOR"//식별자 생성기를 설정해 놓은 USER_SEQ_GEN으로설정
    )
    private int id;

    @Column(nullable = false)
    private Long key;

    @Column(nullable = false)
    private String token;

    public RefreshToken updateToken(String token) {
        this.token = token;
        return this;
    }

    @Builder
    public RefreshToken(Long key, String token) {
        this.key = key;
        this.token = token;
    }
}

