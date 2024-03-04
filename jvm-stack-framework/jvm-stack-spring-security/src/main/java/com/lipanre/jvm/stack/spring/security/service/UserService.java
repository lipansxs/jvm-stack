package com.lipanre.jvm.stack.spring.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lipanre.jvm.stack.spring.security.domain.User;


/**
 * @author LiPan
 */
public interface UserService extends IService<User> {

    /**
     * 登录service
     *
     * @param user 登入用户
     * @return 登入token
     */
    String login(User user);

    /**
     * 退出登入
     *
     * @return 退出登入结果
     */
    Boolean logout();
}
