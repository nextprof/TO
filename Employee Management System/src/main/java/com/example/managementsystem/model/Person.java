package com.example.managementsystem.model;

import lombok.Getter;

@Getter
public final class Person {

    private final String name;
    private final String surname;
    private final String email;
    private final String telephone;

    public Person(String name, String surname, String email, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

}
