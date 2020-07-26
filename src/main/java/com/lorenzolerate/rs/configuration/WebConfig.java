package com.lorenzolerate.rs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lorenzolerate.rs.converter.StringArrayToTechnologySetConverter;
import com.lorenzolerate.rs.converter.StringToTechnologySetConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringArrayToTechnologySetConverter());
		registry.addConverter(new StringToTechnologySetConverter());
	}
}