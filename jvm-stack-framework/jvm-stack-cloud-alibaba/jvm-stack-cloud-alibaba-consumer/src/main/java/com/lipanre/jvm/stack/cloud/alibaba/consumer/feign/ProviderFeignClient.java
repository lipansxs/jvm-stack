package com.lipanre.jvm.stack.cloud.alibaba.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider-service", path = "/provider", contextId = "ProviderFeignClient")
public interface ProviderFeignClient {

    @GetMapping("/hello/{message}")
    String hello(@PathVariable("message") String message);

}
