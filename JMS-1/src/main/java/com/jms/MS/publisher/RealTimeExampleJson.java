package com.jms.MS.publisher;

import netscape.javascript.JSObject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class RealTimeExampleJson {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        Connection connection;

        {
            try {
                //creating a connection with activeMQConnection
                connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("demo");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("fromDate", "12/09/2022");
                jsonObject.put("toDate", "19/09/2022");
                jsonObject.put("email", "abc@gmail.com");

                TextMessage textMessage = session.createTextMessage(jsonObject.toString());

                MessageProducer messageProducer = session.createProducer(destination);
                messageProducer.send(textMessage);
                System.out.println("Published");

                session.close();
                connection.close();


            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
