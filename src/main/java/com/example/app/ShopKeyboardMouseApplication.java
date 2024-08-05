package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.app" }, exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class ShopKeyboardMouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopKeyboardMouseApplication.class, args);
	}

}
