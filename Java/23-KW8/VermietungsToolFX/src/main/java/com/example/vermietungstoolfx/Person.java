package com.example.vermietungstoolfx;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;



    public Person(String firstName, String lastName, LocalDate birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        Period period = Period.between(birthday, LocalDate.now());
        return period.getYears();
    }

}
