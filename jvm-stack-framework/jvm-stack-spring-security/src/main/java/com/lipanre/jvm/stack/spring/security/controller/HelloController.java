package com.lipanre.jvm.stack.spring.security.controller;

import com.lipanre.jvm.stack.spring.security.http.Response;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello controller
 *
 * @author LiPan
 */
@RestController
public class HelloController {

    @PreAuthorize("hasAuthority('admin-abc')")
    @GetMapping("/hello")
    public Response<String> hello() {
        return Response.success("hello");
    }

}
