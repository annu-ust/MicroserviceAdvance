package com.ust.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvDetails {
	//created on 31/05/2023
	@Value("${spring.application.name}")
	private String appServerName;
	@Value("${server.port}")
	private String serverPort;
	public String getAppServerName() {
		return appServerName;
	}
	public void setAppServerName(String appServerName) {
		this.appServerName = appServerName;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	@Override
	public String toString() {
		return "EnvDetails [appServerName=" + appServerName + ", serverPort=" + serverPort + "]";
	}
	
	
	

}
