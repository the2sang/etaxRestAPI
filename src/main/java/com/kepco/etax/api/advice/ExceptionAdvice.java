package com.kepco.etax.api.advice;

import com.kepco.etax.api.domain.response.CommonResult;
import com.kepco.etax.api.exception.*;
import com.kepco.etax.api.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;
    private final MessageSource messageSource;

    /***
     * -9999
     * default Exception
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        log.info(String.valueOf(e));
        return responseService.getFailResult
                (Integer.parseInt(getMessage("unKnown.code")), getMessage("unKnown.msg"));
    }

    /***
     * -1000
     * 유저를 찾지 못했을 때 발생시키는 예외
     */
    @ExceptionHandler(EtaxUserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult userNotFoundException(HttpServletRequest request, EtaxUserNotFoundException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("userNotFound.code")), getMessage("userNotFound.msg")
        );
    }

    /***
     * -1001
     * 유저 이메일 로그인 실패 시 발생시키는 예외
     */
    @ExceptionHandler(EmailLoginFailedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected CommonResult emailLoginFailedException(HttpServletRequest request, EmailLoginFailedException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("emailLoginFailed.code")), getMessage("emailLoginFailed.msg")
        );
    }

    /***
     * -1001
     * 유저 이메일 로그인 실패 시 발생시키는 예외
     */
    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected CommonResult loginFailedException(HttpServletRequest request, LoginFailedException e) {
        return responseService.getFailResult(
            Integer.parseInt(getMessage("loginFailed.code")), getMessage("loginFailed.msg")
        );
    }


    /***
     * -1002
     * 회원 가입 시 이미 로그인 된 이메일인 경우 발생 시키는 예외
     */
    @ExceptionHandler(EmailSignupFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult emailSignupFailedException(HttpServletRequest request, EmailSignupFailedException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("emailSignupFailed.code")), getMessage("emailSignupFailed.msg")
        );
    }

    /**
     * -1003
     * 전달한 Jwt 이 정상적이지 않은 경우 발생 시키는 예외
     */
    @ExceptionHandler(AuthenticationEntryPointException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected CommonResult authenticationEntrypointException(HttpServletRequest request, AuthenticationEntryPointException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("authenticationEntrypoint.code")), getMessage("authenticationEntrypoint.msg")
        );
    }

    /**
     * -1004
     * 권한이 없는 리소스를 요청한 경우 발생 시키는 예외
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected CommonResult accessDeniedException(HttpServletRequest request, AccessDeniedException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("accessDenied.code")), getMessage("accessDenied.msg")
        );
    }

    /**
     * -1005
     * refresh token 에러시 발생 시키는 에러
     */
    @ExceptionHandler(RefreshTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected CommonResult refreshTokenException(HttpServletRequest request, RefreshTokenException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("refreshTokenInValid.code")), getMessage("refreshTokenInValid.msg")
        );
    }

    /**
     * -1006
     * 액세스 토큰 만료시 발생하는 에러
     */
    @ExceptionHandler(ExpiredAccessTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected CommonResult expiredAccessTokenException(HttpServletRequest request, ExpiredAccessTokenException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("expiredAccessToken.code")), getMessage("expiredAccessToken.msg")
        );
    }

    /***
     * -1007
     * Social 인증 과정에서 문제 발생하는 에러
     */
    @ExceptionHandler(CommunicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult communicationException(HttpServletRequest request, CommunicationException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("communicationException.code")), getMessage("communicationException.msg")
        );
    }

    /***
     * -1008
     * 기 가입자 에러
     */
    @ExceptionHandler(EtaxUserExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected CommonResult existUserException(HttpServletRequest request, EtaxUserExistException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("userExistException.code")), getMessage("userExistException.msg")
        );
    }


    private String getMessage(String code) {
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
