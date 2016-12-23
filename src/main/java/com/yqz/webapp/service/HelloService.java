package com.yqz.webapp.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import com.yqz.webapp.model.MyMessage;

@Service
public class HelloService {
	private static Logger logger = LoggerFactory.getLogger(HelloService.class);

	public MyMessage sayHello(String msg) {
		
		
		MyMessage message=new MyMessage();
		if (msg == null || msg.trim().equals(""))
			message.setMessage("I say hello.");
		else
			message.setMessage("I say  " + msg);
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
