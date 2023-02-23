package com.example.hellofx;

public class Person {
    private String firstname;
    private String name;
    private String email;
    private String bestFriend;

    public Person(String firstname, String name, String email, String bestFriend){
        this.firstname = firstname;
        this.name = name;
        this.email = email;
        this.bestFriend = bestFriend;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBestFriend(String bestFriend) {
        this.bestFriend = bestFriend;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getBestFriend() {
        return bestFriend;
    }

}
