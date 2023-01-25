package com.noseryoung.blj;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BirthdayCalendar {
    public static final int YEAR = 2022;
    public static void initPersonArray(Person[] persArr) {
        int i = 0;
        String line;
        String splitBy = ";";
        String path = "C:\\Source\\BLJ2022VaNus\\Java\\KW48\\Geburtstagskalender\\src\\com\\noseryoung\\blj\\Data\\data.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] person = line.split(splitBy);

                int year = Integer.parseInt(person[1]);
                int month = Integer.parseInt(person[2]);
                int day = Integer.parseInt(person[3]);
                String name = person[0];

                persArr[i++] = new Person(year, month, day, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sortingData(Person[] persArr) {
        int n = persArr.length;

        //Sorting by Month
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                int monthB = persArr[j - 1].getMonth();
                int monthN = persArr[j].getMonth();

                if (monthB > monthN) {
                    Person tempP = persArr[j];
                    persArr[j] = persArr[j - 1];
                    persArr[j - 1] = tempP;
                }
            }
        }

        //Sorting by Day
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                int dayB = persArr[j - 1].getDay();
                int monthB = persArr[j - 1].getMonth();
                int yearB = persArr[j - 1].getYear();

                LocalDate birthB = LocalDate.of(yearB, monthB, dayB);

                int dayN = persArr[j].getDay();
                int monthN = persArr[j].getMonth();
                int yearN = persArr[j].getYear();

                LocalDate birthN = LocalDate.of(yearN, monthN, dayN);
                if (monthB == monthN) {
                    if (birthN.isBefore(birthB)) {
                        Person tempP = persArr[j];
                        persArr[j] = persArr[j - 1];
                        persArr[j - 1] = tempP;
                    }
                }
            }
        }

    }
    public static void printBirthdays(Person[] persArr, LocalDate today) {
        String[] Months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};

        int monthI = 1;

        for (Person person : persArr) {
            if ((person.getMonth() - 1) != monthI) {
                monthI = person.getMonth() - 1;
                System.out.println("\n" + Months[monthI]);
            }
            String name = person.getName();
            int day = person.getDay();
            int month = person.getMonth();
            int year = person.getYear();

            LocalDate birth = LocalDate.of(year, month, day);
            LocalDate birthDay = LocalDate.of(YEAR, month, day);

            int age = Period.between(birth, today).getYears();

            int daysToBirthday = (int) ChronoUnit.DAYS.between(today, birthDay);

            System.out.println("  " + day + ". " + name + " (" + age + ")");

            if (daysToBirthday > 0) {
                System.out.println("    Turns " + (age + 1) + ". in " + daysToBirthday + ". Days\n");
            } else if (daysToBirthday == 0) {
                System.out.println("    Happy Birthday " + name + "\uD83E\uDD73\n");
            } else {
                int positiveDays = Math.abs(daysToBirthday);
                System.out.println("    Got " + (age) + ". from " + positiveDays + ". Days\n");
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("\n-------------------------------------");
        System.out.println("|         Geburtstage " + YEAR + "          |");
        System.out.println("-------------------------------------");

        Person[] persArr = new Person[40];
        initPersonArray(persArr);


        LocalDate todayCorrect = LocalDate.now();
        LocalDate today = LocalDate.of(YEAR, todayCorrect.getMonth(), todayCorrect.getDayOfMonth());

        sortingData(persArr);

        printBirthdays(persArr, today);
    }
}
