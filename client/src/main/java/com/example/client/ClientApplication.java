package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClientApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(ClientApplication.class, args);
    ShopClient shopClient = ctx.getBean(ShopClient.class);
    shopClient.run();
  }

}
