package com.lessons.service;

import com.lessons.entity.Engine;
import org.springframework.stereotype.Service;

@Service
public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public String start() {
        return engine.run() + " | Car started!";
    }
}
