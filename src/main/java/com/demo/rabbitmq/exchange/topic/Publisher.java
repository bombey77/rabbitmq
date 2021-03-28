package com.demo.rabbitmq.exchange.topic;

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
      String message = "Some message here";
      channel.basicPublish("Topic-Exchange", "tv.mobile.ac", null, message.getBytes());
      // in case Topic-Exchange has binds: #.ac, *.mobile.*, *.tv.*
      // the program will send message to queues: AC and Mobile (queue TV doesn't match)
      // sign '*' means only one word
      // sign '#' means many words
    }
  }
}
