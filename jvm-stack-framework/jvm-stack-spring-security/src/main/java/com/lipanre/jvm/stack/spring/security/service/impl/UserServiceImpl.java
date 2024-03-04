package com.lipanre.jvm.stack.spring.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lipanre.jvm.stack.spring.security.domain.LoginUser;
import com.lipanre.jvm.stack.spring.security.domain.User;
import com.lipanre.jvm.stack.spring.security.exception.BizException;
import com.lipanre.jvm.stack.spring.security.mapper.UserMapper;
import com.lipanre.jvm.stack.spring.security.service.UserService;
import com.lipanre.jvm.stack.spring.security.util.JwtUtil;
import com.lipanre.jvm.stack.spring.security.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author LiPan
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private AuthenticationManager providerManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public String login(User user) {

        // todo 暂时权限没有实现，所以权限列表传空
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(LoginUser.of(user), user.getPassword(), null);
        Authentication authenticate = providerManager.authenticate(authentication);

        // 通过用户id生成jwt
        String userId = ((LoginUser) authenticate.getPrincipal()).getUserId().toString();
        if (!StringUtils.hasLength(userId)) {
            throw new BizException("用户名或密码错误");
        }
        // 将用户信息存入redis，以userId作为key
        redisCache.setCacheMapValue("online:user", userId, authenticate.getPrincipal());
        return JwtUtil.createJWT(userId);
    }

    @Override
    public Boolean logout() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Long userId = ((LoginUser) authentication.getPrincipal()).getUserId();
            redisCache.delCacheMapValue("online:user", userId.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
