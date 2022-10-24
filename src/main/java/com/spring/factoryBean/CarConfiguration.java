package com.spring.factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// identical configuration in Java to the XML above
@Configuration
public class CarConfiguration { 

  @Bean 
  public MyCarFactoryBean carFactoryBean(){ 
	MyCarFactoryBean cfb = new MyCarFactoryBean();
	cfb.setMake("Honda");
	cfb.setYear(1984);
	return cfb;
  }

  @Bean
  public Person aPerson(){ 
	Person person = new Person();
	person.setCar( carFactoryBean().getObject());
	return person; 
  }	
}