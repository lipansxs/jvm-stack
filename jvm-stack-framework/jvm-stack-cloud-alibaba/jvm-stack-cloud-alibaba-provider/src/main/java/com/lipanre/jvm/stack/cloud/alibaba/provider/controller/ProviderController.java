package com.lipanre.jvm.stack.cloud.alibaba.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        System.out.println("provider hello executed.........................");
        return "Hello, " + message;
    }

}
