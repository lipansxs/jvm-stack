package com.lipanre.jvm.stack.spring.security.service.impl;


import com.lipanre.jvm.stack.spring.security.domain.LoginUser;
import com.lipanre.jvm.stack.spring.security.domain.User;
import com.lipanre.jvm.stack.spring.security.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author LiPan
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 设置用户权限列表
        // 这里可以在数据库里面进行查询授权
        return LoginUser.of(user, Arrays.asList("admin", "system:user:list"));
    }
}
