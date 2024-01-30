package com.lipanre.jvmstack.middleware.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author LiPan
 */
@SpringBootApplication
public class MiddlewareRedisApplication {

    @Resource
    private ObjectMapper objectMapper;

    @Data
    static class User {
        private String name;

        private Integer age;
    }


    public static void main(String[] args) {
        SpringApplication.run(MiddlewareRedisApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() throws Exception{
        return (args) -> {
            User user = new User();
            user.setName("lipanre");
            user.setAge(18);
            System.out.println(objectMapper.writeValueAsString(user));
        };
    }
}
