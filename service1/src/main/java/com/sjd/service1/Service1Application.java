package com.sjd.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.sjd.service1.backend.TodoBackendConfiguration;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;

@SpringBootApplication
@Import({TodoBackendConfiguration.class, EventuateDriverConfiguration.class})
public class Service1Application {

	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}
}
