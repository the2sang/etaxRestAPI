package com.kepco.etax.api.controller.v1;


import com.kepco.etax.api.config.security.JwtProvider;
import com.kepco.etax.api.domain.request.jwt.TokenDto;
import com.kepco.etax.api.domain.request.jwt.TokenRequest;
import com.kepco.etax.api.domain.request.login.EtaxUserLoginRequest;
import com.kepco.etax.api.domain.request.login.EtaxUserSignupRequest;
import com.kepco.etax.api.domain.response.SingleResult;
import com.kepco.etax.api.repository.EtaxUserRepository;
import com.kepco.etax.api.service.LoginService;
import com.kepco.etax.api.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = {"1. CreateUser/Login/TokenReissue"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final JwtProvider jwtProvider;
    private final EtaxUserRepository etaxUserRepository;
    private final LoginService loginService;
    private final ResponseService responseService;

    @ApiOperation(value = "로그인", notes = "이메일로 로그인을 합니다.")
    @PostMapping("/login")
    public SingleResult<TokenDto> login(@ApiParam(value = "로그인 요청", required = true) @RequestBody EtaxUserLoginRequest userLoginRequestDto) {

        TokenDto tokenDto = loginService.login(userLoginRequestDto);
        return responseService.getSingleResult(tokenDto);
    }

    @ApiOperation(value = "사용자 생성", notes = "신규 사용자를 생성합니다.")
    @PostMapping("/createUser")
    public SingleResult<Long> signup(@ApiParam(value = "회원 가입 요청 DTO", required = true) @RequestBody EtaxUserSignupRequest userSignupRequestDto) {
        Long signupId = loginService.signup(userSignupRequestDto);
        return responseService.getSingleResult(signupId);
    }

    @ApiOperation(value = "액세스, 리프레시 토큰 재발급",  notes = "엑세스 토큰 만료시 회원 검증 후 리프레쉬 토큰을 검증해서 액세스 토큰과 리프레시 토큰을 재발급합니다.")
    @PostMapping("/reissue")
    public SingleResult<TokenDto> reissue(@ApiParam(value = "토큰 재발급 요청 DTO", required = true) @RequestBody TokenRequest tokenRequestDto) {
        return responseService.getSingleResult(loginService.reissue(tokenRequestDto));
    }
}

