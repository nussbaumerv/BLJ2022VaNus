package com.example.vermietungstoolfx;

import java.time.LocalDate;

public class Employee extends Person{
    private String username;
    private String password;
    public Employee(String firstName, String lastName, LocalDate birthday, String username, String password){
        super(firstName, lastName, birthday);

        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
