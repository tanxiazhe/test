package com.spring.factoryBean;

public class CarBuilder {
    private Car car;

    public  CarBuilder(){
        car = new Car();
    }

    static CarBuilder car(){
        return new CarBuilder();
    }

    public CarBuilder setMake(String make) {
        car.setMake(make);
        return this;
    }

    public Car factory() {
        return car;
    }

    public CarBuilder setYear(int year) {
        car.setYear(year);
        return this;
    }
}
