package com.lipanre.jvm.stack.cloud.alibaba.consumer.controller;

import com.lipanre.jvm.stack.cloud.alibaba.consumer.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/{productId}")
    @GlobalTransactional
    public Boolean create(@PathVariable Long productId) {
        return orderService.createOrder(productId);
    }

}
