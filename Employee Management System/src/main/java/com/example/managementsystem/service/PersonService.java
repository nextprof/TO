package com.example.managementsystem.service;

import com.example.managementsystem.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    public Person getPerson() {
        return new Person("Andrzej","Kwiatkowski", "andrzej.kowalski@gmail.com", "504444499");
    }
}
