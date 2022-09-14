package com.jmsspring.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @JmsListener(destination = "mess")
    public void receiveMessage(String message){
        System.out.println(message);
    }
}
