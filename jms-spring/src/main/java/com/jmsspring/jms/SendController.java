package com.jmsspring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@RestController
@RequestMapping("/api/v1")
public class SendController {

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/send/{message}")
    public String send(@PathVariable("message") String message){
        jmsTemplate.send("mess", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage object = session.createObjectMessage(message);
                return object;
            }
        });
        return message;
    }
}
