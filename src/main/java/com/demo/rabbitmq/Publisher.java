package com.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    // I use try for closing connection and channel
    try (Connection connection = connectionFactory.newConnection();
         Channel channel = connection.createChannel();) {

      String[] messages = {"First", "Second", "Third", "Fourth"};
      for (String message: messages) {
        channel.basicPublish("", "Queue-1", null, message.getBytes());
      }
    }
  }
}
