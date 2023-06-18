package com.geekster.SpringBootAnnotation.Controllers;

import com.geekster.SpringBootAnnotation.MyObject.Car;
import com.geekster.SpringBootAnnotation.email.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    String s;
    @Autowired//start pointing to class car object because object is already made but we have to point them.
    @Qualifier("blue")
    Car c;
    @Autowired
    MailHandler mailHandler;
    @GetMapping("color")
    public Car getCarColor(){
        System.out.println("Starting to send out Mail");

        mailHandler.sendMail();


        String s= new Car("blue").toString();
        return new Car("blue");


    }


}
