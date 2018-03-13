package com.sjd.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

@SpringBootApplication
@Import({EventuateDriverConfiguration.class})
public class Service2Application {

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }
}
