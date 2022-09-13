package com.jms.MS.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

public class ConsumerTopic2 {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        Connection connection;

        {
            try {
                //creating a connection with activeMQConnection
                connection = connectionFactory.createConnection();
                connection.setClientID("2");
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Topic destination = session.createTopic("demo-Topic");

                MessageConsumer messageConsumer = session.createDurableSubscriber(destination, "Consumer-2");

                messageConsumer.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message message) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println(textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }

                    }
                });
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    }

