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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
