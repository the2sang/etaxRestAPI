package com.kepco.etax.api.config.security;

import com.google.gson.Gson;
import com.kepco.etax.api.domain.response.CommonResult;
import com.kepco.etax.api.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler {


    private final ResponseService responseService;

    private final MessageSource messageSource;

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {

        //response.sendRedirect("/exception/accessDenied");
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "AccessDenied");
        setResponse(response );

    }

    private void setResponse(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        CommonResult commonResult =
                responseService.getFailResult(Integer.parseInt(getMessage("expiredAccessToken.code")), getMessage("expiredAccessToken.msg"));
        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(commonResult));
    }

    private String getMessage(String code) {
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
