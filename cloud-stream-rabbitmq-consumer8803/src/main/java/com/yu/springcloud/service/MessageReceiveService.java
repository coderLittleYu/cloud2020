package com.yu.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * springcloud stream message
 */
@EnableBinding(Sink.class)
@Component
@Slf4j
public class MessageReceiveService {

    @Value("${server.port}")
    private String port;

    @Resource
    private MessageChannel input;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message){
        log.info("*** port:"+port+"\t"+message.getPayload());
    }
}
