package com.lms.restapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestApiDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApiDemoApplication.class, args);
  }

}
