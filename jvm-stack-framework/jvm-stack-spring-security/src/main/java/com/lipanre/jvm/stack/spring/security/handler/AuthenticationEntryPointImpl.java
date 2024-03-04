package com.lipanre.jvm.stack.spring.security.handler;

import com.alibaba.fastjson.JSON;
import com.lipanre.jvm.stack.spring.security.http.Response;
import com.lipanre.jvm.stack.spring.security.util.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author LiPan
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Response<String> error = Response.error(authException.getMessage());
        String json = JSON.toJSONString(error);
        WebUtils.renderString(response, json);
    }
}
