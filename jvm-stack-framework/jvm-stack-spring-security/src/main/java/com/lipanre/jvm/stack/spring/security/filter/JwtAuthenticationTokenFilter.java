package com.lipanre.jvm.stack.spring.security.filter;

import com.lipanre.jvm.stack.spring.security.domain.LoginUser;
import com.lipanre.jvm.stack.spring.security.http.Response;
import com.lipanre.jvm.stack.spring.security.util.JwtUtil;
import com.lipanre.jvm.stack.spring.security.util.RedisCache;
import com.lipanre.jvm.stack.spring.security.util.WebUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * jwt拦截器
 *
 * @author LiPan
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 1. 从请求中获取到token
        String token = request.getHeader("token");

        // 有些接口不需要登入即可访问，那么这个时候是没有token的
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String userId;
        try {
            // 2. 解析token（jwt）获取用户id
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            WebUtils.renderString(response, Response.error("token非法").toJSON());
            return;
        }
        // 3. 通过用户id，从redis中获取用户详情
        LoginUser loginUser = redisCache.getCacheMapValue("online:user", userId);
        if (Objects.isNull(loginUser)) {
            WebUtils.renderString(response, Response.error("token非法").toJSON());
            return;
        }

        // 4. 将用户详情封装成一个Authentication对象存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, loginUser.getPassword(), loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }

}
