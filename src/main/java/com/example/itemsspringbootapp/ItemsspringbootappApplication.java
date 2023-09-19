package com.example.itemsspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ItemsspringbootappApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ItemsspringbootappApplication.class, args);
		SpringApplication application = new SpringApplication(new Class[] {ItemsspringbootappApplication.class});
		Properties properties = new Properties();
		properties.put("server.port", 8088 );
		application.setDefaultProperties(properties);
		application.run(args);
	}

}
