package com.eurekaclientdemo.system.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eurekaclientdemo.system.mvc.service.EurekaServiceController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("test1")
public class TestServiceController {

	@Autowired
	private EurekaServiceController eurekaServiceController;

	@Autowired
	private RestTemplate restTemplate;

	private static final String test2ServiceName = "eureka-client-testService2";

	@GetMapping(value = "/test2/{message}")
	public String getTest2Service(@PathVariable String message) {
		String test2HomePage = eurekaServiceController.getServiceUrl(test2ServiceName);
		test2HomePage = new StringBuilder(test2HomePage).append("/test2/").append(message).toString();
		String response = restTemplate.getForObject(test2HomePage, String.class);
		return response;
	}

	@GetMapping(value = "/test2/ribbon/{message}")
	public String getTest2RibbonService(@PathVariable String message) {
		String url = new StringBuilder("http://").append("eureka-client-testService2").append("/test2/").append(message)
				.toString();
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}

	@GetMapping(value = "/{message}")
	public String getAllMessagesByMemberId(@PathVariable String message) throws JsonProcessingException {
		String messages = "finish call  {" + message + "} in test1 service";
		return new ObjectMapper().writeValueAsString(messages);
	}

}
