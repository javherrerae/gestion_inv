package com.example.desconsolidacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DesconsolidacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesconsolidacionApplication.class, args);
	}

}
