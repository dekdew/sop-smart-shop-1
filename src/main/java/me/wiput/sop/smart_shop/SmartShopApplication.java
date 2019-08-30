package me.wiput.sop.smart_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SmartShopApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmartShopApplication.class, args);
  }

  @RequestMapping("/")
  String index() {
    return "Hi!";
  }

}
