package com.yu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class feignConfig {
    @Bean
    public Logger.Level getLogerLevel(){
        //所有日志
        return  Logger.Level.FULL;
    }
}
