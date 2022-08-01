package com.ccsw.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.config.mapper.BeanMapperImpl;
import com.devonfw.module.beanmapping.common.base.BaseOrikaConfig;
import com.devonfw.module.json.common.base.ObjectMapperFactory;
import com.fasterxml.jackson.databind.Module;

import ma.glasnost.orika.MapperFactory;

/**
 * Java bean configuration for Orika. The method
 * {@link #configureCustomMapping(MapperFactory)} from {@link BaseOrikaConfig}
 * can be overridden as per requirements.
 * 
 * @author Francisco Sanz Pino
 */

@Configuration
public class BeansOrikaConfig extends BaseOrikaConfig {

	/**
	 * Devuelve la implementación de {@link BeanMapper}
	 */
	@Override
	@Bean
	public BeanMapper getBeanMapper() {

		return new BeanMapperImpl();
	}

	@Bean
	public Module configureObjectMapper8() {

		ObjectMapperFactory objectMapper = new ObjectMapperFactory();
		return objectMapper.getExtensionModule();
	}
}
