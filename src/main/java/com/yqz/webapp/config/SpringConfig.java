package com.yqz.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = SpringConfig.class)*/
public class SpringConfig extends WebMvcConfigurationSupport {

	public SpringConfig(){
		
	}
}
