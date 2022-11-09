package com.noseyoung.blj;

public class Person {
    private String firstname;
    private String name;
    private String email;
    private String bestFriend;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.name = lastname;
    }

    public void printPerson() {
        System.out.println(firstname + " " + name + "\nEmail: " + email + "\nBestfriend: " + bestFriend);
        System.out.println("--------------------------------------------------");
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBestFriend(String bestFriend) {
        this.bestFriend = bestFriend;
    }
}
