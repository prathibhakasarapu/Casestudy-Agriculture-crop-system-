package com.cropdetails.systemcropdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SystemCropdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemCropdetailsApplication.class, args);
	}

}
