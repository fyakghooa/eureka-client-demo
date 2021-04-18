package com.eurekaclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaClientDemoApplication.class, args);

	}

	@Bean
	@LoadBalanced // 使RestTemplate自動配置成支援Ribbon
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
