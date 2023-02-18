package com.jean.flitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The FlitterApplication class is the entry point for the Spring Boot
 * application.
 *
 * This class uses the @SpringBootApplication annotation, which enables
 * component scanning and auto-configuration for the application.
 */
@SpringBootApplication
public class FlitterApplication {

  /**
   * The main method starts the Spring Boot application.
   *
   * @param args the command line arguments to pass to the application
   */
  public static void main(String[] args) {
    SpringApplication.run(FlitterApplication.class, args);
  }
}
