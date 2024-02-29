package com.lipanre.jvm.stack.cloud.alibaba.consumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lipanre.jvm.stack.cloud.alibaba.consumer.domain.Order;

public interface OrderService extends IService<Order> {

    /**
     * 创建一个新的订单
     */
    Boolean createOrder(Long productId);
}
