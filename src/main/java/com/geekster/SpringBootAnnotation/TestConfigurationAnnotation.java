package com.geekster.SpringBootAnnotation;

import com.geekster.SpringBootAnnotation.MyObject.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfigurationAnnotation {
    public String s;

    @Bean("blue")
    public Car getCarObject1(){
        s= new Car("Blue").toString();
        return new Car("Blue");
    }

}
