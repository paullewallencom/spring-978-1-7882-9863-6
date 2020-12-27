package com.packtpub.yummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class YummyApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(YummyApplication.class, args);
		System.out.println("#######################");
		System.out.println("##### Initialized! ####");
		System.out.println("#######################");
	}
}
