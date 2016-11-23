package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Person person = new Person();

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome, user.");

        try {
            person = person.loadInfo();
            System.out.println("Loaded saved info.");

        } catch (Exception e) {
            System.out.println("Start new application.");

        }
        if (person.name == null) {
            person.enterName();
        }
        if (person.age == 0) {
            person.enterAge();
        }
        if (person.address == null) {
            person.enterAddress();

        }
        if (person.eyeColor == null) {
            person.enterEyeColor();

        }
        if (person.occupation == null) {
            person.enteroccupation();

        }
        person.saveInfo(person);
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
        System.out.println("Address: " + person.address);
        System.out.println("Eye Color: " + person.eyeColor);
        System.out.println("Occupation: " + person.occupation);
        System.out.println("Would you like to make any changes? [y/n]");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            System.out.println("Which would you like to change [name/age/address/eye color/occupation.");
                    String change = scanner.nextLine();

            if (change.equalsIgnoreCase("name")) {
                System.out.println("Enter new name");
                person.enterName();
            }
            if (change.equalsIgnoreCase("age")) {
                System.out.println("Enter new age");
                person.enterAge();
            }
            if (change.equalsIgnoreCase("Address")) {
                System.out.println("Enter new address");
                person.enterAddress();
            }
            if (change.equalsIgnoreCase("eye color")) {
                System.out.println("Enter new eye color");
                person.enterEyeColor();
            }
            if(change.equalsIgnoreCase("Occupation")) {
                System.out.println("Enter new occupation");
                person.enteroccupation();
            }
            person.saveInfo(person);


        }




    }

}
