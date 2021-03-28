package com.demo.rabbitmq.exchange.headers;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Publisher {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {
      String message = "Some message here";

      Map<String, Object> map = new HashMap<>();
      map.put("item1", "mobile");
      map.put("item2", "television");

      // import com.rabbitmq.client.AMQP.BasicProperties
      BasicProperties properties = new BasicProperties();
      properties = properties.builder().headers(map).build();

      channel.basicPublish("Headers-Exchange", "", properties, message.getBytes());
    }
  }
}
