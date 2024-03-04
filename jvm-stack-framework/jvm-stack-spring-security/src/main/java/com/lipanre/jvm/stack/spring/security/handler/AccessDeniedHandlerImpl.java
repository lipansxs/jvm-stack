package com.lipanre.jvm.stack.spring.security.handler;

import com.alibaba.fastjson.JSON;
import com.lipanre.jvm.stack.spring.security.http.Response;
import com.lipanre.jvm.stack.spring.security.util.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author LiPan
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Response<String> error = Response.error(accessDeniedException.getMessage());
        String json = JSON.toJSONString(error);
        WebUtils.renderString(response, json);
    }
}
