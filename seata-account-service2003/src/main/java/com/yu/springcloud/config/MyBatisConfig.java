package com.yu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.yu.springcloud.dao"})
public class MyBatisConfig {
}
