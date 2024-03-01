package com.lipanre.jvm.stack.cloud.alibaba.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "provider-service", path = "/stock", contextId = "stockFeignClient")
public interface StockFeignClient {

    @PostMapping("/desc/{id}")
    void desc(@PathVariable("id") Long id);

}
