package com.demo.rabbitmq.json;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class JsonExample {

  public static void main(String[] args) throws IOException, TimeoutException {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    try (Connection connection = connectionFactory.newConnection();
         Channel channel = connection.createChannel()) {

      JSONObject json = new JSONObject();
      json.put("from_date", "1/01/1991");
      json.put("to_date", "31/12/1991");
      json.put("email", "xyz@gmai.com");
      json.put("query", "SELECT * FROM user");

      channel.basicPublish("", "Queue-1", null, json.toString().getBytes());
    }
  }
}
