package com.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.StringUtils;

public class MyCarFactoryBean implements FactoryBean<Car> {
  private String make; 
  private int year ;

  public void setMake(String m){ this.make =m ; }

  public void setYear(int y){ this.year = y; }

  public Car getObject(){
    // wouldn't be a very useful FactoryBean 
    // if we could simply instantiate the object!
    CarBuilder cb = CarBuilder.car();
	
    if(year!=0) cb.setYear(this.year);
    if(StringUtils.hasText(this.make)) cb.setMake( this.make );
    return cb.factory(); 
  }

  public Class<Car> getObjectType() { return Car.class ; } 

  public boolean isSingleton() { return false; }
}