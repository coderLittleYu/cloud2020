package com.yu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡规则
 * ribbon 规定不能将此类与@ComponentScan 扫描路径的包及其子包路径相同
 * @SpringBootApplication 注解里有@ComponentScan
 */
@Configuration
public class Myrule {

    @Bean
    public IRule getRandomRule(){
        return new RandomRule();
    }
}
