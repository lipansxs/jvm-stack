package com.lipanre.jvm.stack.cloud.alibaba.consumer.controller;

import com.lipanre.jvm.stack.cloud.alibaba.consumer.feign.ProviderFeignClient;
import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ProviderFeignClient providerFeignClient;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://provider-service/provider/hello/" + name, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/hello-feign/{message}")
    public String helloFeign(@PathVariable String message) {
        return providerFeignClient.hello(message);
    }

}
