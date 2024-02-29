package com.lipanre.jvm.stack.cloud.alibaba.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lipanre.jvm.stack.cloud.alibaba.consumer.domain.Order;
import com.lipanre.jvm.stack.cloud.alibaba.consumer.feign.StockFeignClient;
import com.lipanre.jvm.stack.cloud.alibaba.consumer.mapper.OrderMapper;
import com.lipanre.jvm.stack.cloud.alibaba.consumer.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final StockFeignClient stockFeignClient;

    @Override
    public Boolean createOrder(Long productId) {

        // 减少库存
        stockFeignClient.desc(productId);

        int a = 1/0;
        // 创建订单
        save(new Order(1L, productId, 1));

        return true;
    }
}
