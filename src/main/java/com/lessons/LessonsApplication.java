package com.lessons;

import com.lessons.service.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonsApplication {
    public static void main(String[] args) {
//
        ApplicationContext context = SpringApplication.run(LessonsApplication.class, args);
//        GreetingService service = context.getBean(GreetingService.class);
//        System.out.println(service.greeting("Aydan"));

        Car car = context.getBean(Car.class);
        System.out.println(car.start());
    }
}
