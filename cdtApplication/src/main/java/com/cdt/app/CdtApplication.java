package com.cdt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cdt.app.*"})
public class CdtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdtApplication.class, args);
	}

}
