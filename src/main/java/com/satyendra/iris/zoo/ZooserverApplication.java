
package com.satyendra.iris.zoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ZooserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooserverApplication.class, args);
	}

}
