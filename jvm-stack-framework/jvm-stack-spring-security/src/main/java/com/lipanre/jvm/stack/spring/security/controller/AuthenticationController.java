package com.lipanre.jvm.stack.spring.security.controller;


import com.lipanre.jvm.stack.spring.security.domain.User;
import com.lipanre.jvm.stack.spring.security.http.Response;
import com.lipanre.jvm.stack.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登入相关
 *
 * @author LiPan
 */
@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Response<String> login(@RequestBody User user) {
        return Response.success(userService.login(user));
    }

    @PostMapping("/logout")
    public Response<Boolean> logout() {
        return Response.success(userService.logout());
    }

}
