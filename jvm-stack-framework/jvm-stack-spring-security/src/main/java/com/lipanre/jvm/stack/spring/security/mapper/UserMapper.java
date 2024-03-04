package com.lipanre.jvm.stack.spring.security.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lipanre.jvm.stack.spring.security.domain.User;

/**
 * @author LiPan
 */
public interface UserMapper extends BaseMapper<User> {

    default User selectUserByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery().eq(User::getUserName, username);
        return this.selectOne(wrapper);
    }
}
