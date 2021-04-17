package com.eurekaclientdemo.system.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class EurekaServiceController {

	@Autowired
	private EurekaClient eurekaClient;

	public String getServiceUrl(String serviceName) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(serviceName, false);
		return instanceInfo.getHomePageUrl();
	}

}
