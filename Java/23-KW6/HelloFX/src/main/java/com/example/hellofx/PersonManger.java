package com.example.hellofx;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonManger {
    private ArrayList<Person> arrPersons = new ArrayList<Person>();

    public PersonManger() {
        launchPM();
    }


    public void setPerson(int index, String firstName, String lastName, String email) {
        arrPersons.get(index).setFirstname(firstName);
        arrPersons.get(index).setName(lastName);
        arrPersons.get(index).setEmail(email);
    }

    public int deletePerson(int index) {
        int retIndex = index;
        if (arrPersons.size() > 1) {
            arrPersons.remove(index);
            if (index != 0) {
                retIndex--;
            }
        }
        return retIndex;

    }


    public int addPeopleToList() {
        Person NewPerson = new Person("", "", "", "");
        arrPersons.add(NewPerson);

        return arrPersons.indexOf(NewPerson);
    }

    public void launchPM() {
        addPeopleToList();
    }

    public String getName(int index) {
        String name = arrPersons.get(index).getName();

        return name;
    }

    public String getEmail(int index) {

        String email = arrPersons.get(index).getEmail();

        return email;
    }

    public String getFirstname(int index) {

        String firstName = arrPersons.get(index).getFirstname();

        return firstName;
    }

    public String getBestFriend(int index) {
        String name = arrPersons.get(index).getName();
        return name;
    }

    public int getSize() {
        int size = arrPersons.size();
        return size;
    }
}
