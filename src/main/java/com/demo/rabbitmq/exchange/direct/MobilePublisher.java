package com.demo.rabbitmq.exchange.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MobilePublisher {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
      String message = "This message is for mobile queue";

      channel.basicPublish("Direct-Exchange", "mobile", null, message.getBytes());
    }
  }
}
