package com.noseryoung.blj;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.lang.Math;

public class BirthdayCalendar {
    public static final int YEAR = 2022;
    public static void initPersonArray(Person[] persArr) {
        int i = 0;
        persArr[i++] = new Person(2007,5,1,"Marko");
        persArr[i++] = new Person(2006,11,23,"Dylan");
        persArr[i++] = new Person(2006,7,23,"Samuel");
        persArr[i++] = new Person(2006,5,21,"Luis");
        persArr[i++] = new Person(2001,12,19,"Sairam");
        persArr[i++] = new Person(2002,11,13,"Tsering Lhamo");
        persArr[i++] = new Person(2004,9,27,"Nikola");
        persArr[i++] = new Person(2007,1,18,"Noah");
        persArr[i++] = new Person(2007,1,25,"Aurora");
        persArr[i++] = new Person(1999,12,12,"Jasmin");
        persArr[i++] = new Person(2006,11,8,"Fatima");
        persArr[i++] = new Person(2002,6,18,"Sheung Tsung");
        persArr[i++] = new Person(2006,1,23,"Timofey");
        persArr[i++] = new Person(2007,3,7,"Ruben");
        persArr[i++] = new Person(2006,12,26,"Aabish");
        persArr[i++] = new Person(2005,7,23,"Ömer Burak");
        persArr[i++] = new Person(2006,5,23,"Emma");
        persArr[i++] = new Person(2007,7,12,"Oscar");
        persArr[i++] = new Person(2004,10,15,"Jessica");
        persArr[i++] = new Person(2006,11,13,"Nikhil");
        persArr[i++] = new Person(2006,5,7,"Elmar");
        persArr[i++] = new Person(2006,5,22,"Henri");
        persArr[i++] = new Person(2005,5,21,"Virginia");
        persArr[i++] = new Person(2005,8,16,"Yan");
        persArr[i++] = new Person(2007,4,25,"Ilija");
        persArr[i++] = new Person(2007,4,8,"Valentin");
        persArr[i++] = new Person(2006,7,25,"Loris");
        persArr[i++] = new Person(2007,6,1,"Dominic");
        persArr[i++] = new Person(2006,10,20,"Lorena");
        persArr[i++] = new Person(2005,3,10,"Edgar");
        persArr[i++] = new Person(2006,12,16,"Richard");
        persArr[i++] = new Person(2003,1,1,"Saad");
        persArr[i++] = new Person(2004,2,26,"Filip");
        persArr[i++] = new Person(2004,5,4,"Duy Minh");
        persArr[i++] = new Person(2006,3,7,"Timothy");
        persArr[i++] = new Person(2006,4,7,"Jamie" );
        persArr[i++] = new Person(2006,3,18,"Jasmin");
        persArr[i++] = new Person(2002,4,25,"Sharujah");
        persArr[i++] = new Person(2005,3,4,"Darko");
        persArr[i++] = new Person(2006,4,7,"Dina");
    }

    public static void main(String[] args) {
        System.out.println("\n-------------------------------------");
        System.out.println("|         Geburtstage "+ YEAR +"          |");
        System.out.println("-------------------------------------");

        Person[] persArr = new Person[40];
        initPersonArray(persArr);

        String[] Months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};

        int monthI = 1;

        LocalDate todayCorrect = LocalDate.now();
        LocalDate today = LocalDate.of(YEAR, todayCorrect.getMonth(), todayCorrect.getDayOfMonth());

        int n = persArr.length;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                int monthB = persArr[j-1].getMonth();
                int monthN = persArr[j].getMonth();

                if(monthB > monthN){
                    Person tempP = persArr[j];
                    persArr[j] = persArr[j-1];
                    persArr[j-1] = tempP;
                }
            }
        }

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                int dayB = persArr[j-1].getDay();
                int monthB = persArr[j-1].getMonth();
                int yearB = persArr[j-1].getYear();

                LocalDate birthB = LocalDate.of(yearB, monthB, dayB);

                int dayN = persArr[j].getDay();
                int monthN = persArr[j].getMonth();
                int yearN = persArr[j].getYear();

                LocalDate birthN = LocalDate.of(yearN, monthN, dayN);
                if(monthB == monthN) {
                    if (birthN.isBefore(birthB)) {
                        Person tempP = persArr[j];
                        persArr[j] = persArr[j - 1];
                        persArr[j - 1] = tempP;
                    }
                }
            }
        }

        for (int i = 0; i < persArr.length; i++) {
            if ((persArr[i].getMonth() - 1) != monthI) {
                monthI = persArr[i].getMonth() - 1;
                System.out.println("\n" + Months[monthI]);
            }
            String name = persArr[i].getName();
            int day = persArr[i].getDay();
            int month = persArr[i].getMonth();
            int year = persArr[i].getYear();

            LocalDate birth = LocalDate.of(year, month, day);
            LocalDate birthDay = LocalDate.of(YEAR, month, day);

            int age = Period.between(birth, today).getYears();

            int daysToBirthday = (int) ChronoUnit.DAYS.between(today, birthDay);

            System.out.println("  " + day + ". " + name + " (" + age + ")");

            if (daysToBirthday > 0) {
                System.out.println("    Turns " + (age + 1) + ". in " + daysToBirthday + ". Days\n");
            } else if (daysToBirthday == 0) {
                System.out.println("    Happy Birthday "+ name + "\uD83E\uDD73\n");
            } else {
                int positiveDays = Math.abs(daysToBirthday);
                System.out.println("    Got " + (age) + ". from " + positiveDays + ". Days\n");
            }
        }

    }
}
