package com.yqz.webapp.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yqz.webapp.model.MyMessage;

@Service
public class HelloService {
	private static Logger logger = LoggerFactory.getLogger(HelloService.class);
	@Value("${developer.nickname:'noname'}")
	private String appName;
	// @Value("#{predefineProperties['app.version']?:'0.0.0'}")
	@Value("${app.version:'0.0.0'}")
	private String appVersion;

	public MyMessage sayHello(String msg) {

		String app = String.format("%s(version:%s)", appName, appVersion);
		MyMessage message = new MyMessage();
		if (msg == null || msg.trim().equals(""))
			message.setMessage(app + " says hello.");
		else
			message.setMessage(app + " says  " + msg);
		return message;
	}

	@PostConstruct
	public void init() {
		logger.info("Bean MyMessage is going through init.");
	}

	@PreDestroy
	public void destroy() {
		logger.info("Bean MyMessage will destroy now.");
	}
}
