package com.jb.project2.beans;

import com.jb.project2.security.LoginInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Web {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
