package com.jms.MS.publisher;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;


public class PublisherTopic {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        Connection connection;

        {
            try {
                //creating a connection with activeMQConnection
                //Single producer
                connection = connectionFactory.createConnection();

                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Topic destination = session.createTopic("demo-Topic");

                TextMessage textMessage = session.createTextMessage("First message");

                MessageProducer producer = session.createProducer(destination);
                producer.send(textMessage);

                System.out.println("Message published");



                /*
                connection = connectionFactory.createConnection();

                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("demo");

                MessageProducer producer = session.createProducer(destination);
                String[] message = {"First message", "second message", "third message"};

                for (String messages: message){
                    TextMessage textMessage = session.createTextMessage(messages);
                    producer.send(textMessage);
                }

                System.out.println("Message published");
                */

                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
