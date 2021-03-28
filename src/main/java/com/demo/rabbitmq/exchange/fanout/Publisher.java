package com.demo.rabbitmq.exchange.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
      String message = "Message to Mobile and TV queues";
      // Note routingKey should be as empty String
      channel.basicPublish("Fanout-Exchange", "", null, message.getBytes());
      // the program will send the message to all queues which are bind with the Fanout-Exchange
    }
  }
}
