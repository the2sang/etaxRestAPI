package com.kepco.etax.api.service;


import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.entity.EtaxUser;
import com.kepco.etax.api.domain.entity.security.RefreshToken;
import com.kepco.etax.api.domain.request.jwt.TokenDto;
import com.kepco.etax.api.domain.request.jwt.TokenRequest;
import com.kepco.etax.api.domain.request.login.EtaxUserLoginRequest;
import com.kepco.etax.api.domain.request.login.EtaxUserSignupRequest;
import com.kepco.etax.api.exception.*;
import com.kepco.etax.api.repository.EtaxUserRepository;
import com.kepco.etax.api.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.kepco.etax.api.exception.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    //@Autowired
    private final EtaxUserRepository etaxUserRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    //@Autowired
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenDto login(EtaxUserLoginRequest etaxUserLoginRequest) {

        // 회원 정보 존재하는지 확인
//        EtaxUser user = etaxUserRepository.findByEmail(etaxUserLoginRequest.getEmail())
//                .orElseThrow(EmailLoginFailedException::new);
        EtaxUser user = etaxUserRepository.findByUsername(etaxUserLoginRequest.getUsername())
            .orElseThrow(LoginFailedException::new);

        // 회원 패스워드 일치 여부 확인
        if (!passwordEncoder.matches(etaxUserLoginRequest.getPassword(), user.getPassword()))
            throw new EmailLoginFailedException();

        // AccessToken, RefreshToken 발급
        TokenDto tokenDto = jwtProvider.createTokenDto(user.getUserId(), user.getRoles());

        // RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .key(user.getUserId())
                .token(tokenDto.getRefreshToken())
                .build();
        refreshTokenRepository.save(refreshToken);
        return tokenDto;
    }

    @Transactional
    public Long signup(EtaxUserSignupRequest userSignupDto) {
        if (etaxUserRepository.findByUsername(userSignupDto.getUsername()).isPresent())
            throw new EtaxUserExistException();
        return etaxUserRepository.save(userSignupDto.toEntity(passwordEncoder)).getUserId();
    }

//    @Transactional
//    public Long socialSignup(EtaxUserSignupRequest etaxUserSignupRequest) {
//        if (etaxUserRepository
//                .findByEmailAndProvider(etaxUserSignupRequest.getEmail(), etaxUserSignupRequest.getProvider())
//                .isPresent()
//        ) throw new EtaxUserExistException();
//        return etaxUserRepository.save(etaxUserSignupRequest.toEntity()).getUserId();
//    }

    @Transactional
    public TokenDto reissue(TokenRequest tokenRequestDto) {
        // 만료된 refresh token 에러
        if (!jwtProvider.validationToken(tokenRequestDto.getRefreshToken())) {
            throw new RefreshTokenException();
        }

        // AccessToken 에서 Username (pk) 가져오기
        String accessToken = tokenRequestDto.getAccessToken();
        Authentication authentication = jwtProvider.getAuthentication(accessToken);

        // user pk로 유저 검색 / repo 에 저장된 Refresh Token 이 없음
        EtaxUser user = etaxUserRepository.findById(Long.parseLong(authentication.getName()))
                .orElseThrow(EtaxUserNotFoundException::new);
        RefreshToken refreshToken = refreshTokenRepository.findByKey(user.getUserId())
                .orElseThrow(RefreshTokenException::new);

        // 리프레시 토큰 불일치 에러
        if (!refreshToken.getToken().equals(tokenRequestDto.getRefreshToken()))
            throw new RefreshTokenException();

        // AccessToken, RefreshToken 토큰 재발급, 리프레쉬 토큰 저장
        TokenDto newCreatedToken = jwtProvider.createTokenDto(user.getUserId(), user.getRoles());
        RefreshToken updateRefreshToken = refreshToken.updateToken(newCreatedToken.getRefreshToken());
        refreshTokenRepository.save(updateRefreshToken);

        return newCreatedToken;
    }
}

