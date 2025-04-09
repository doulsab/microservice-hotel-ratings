package com.dd.user.UserService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    // This will manage the name of each services name which are registered in Eureka server to avoid the hostname and port(may get change)
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
