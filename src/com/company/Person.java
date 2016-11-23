package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.company.Main.scanner;

/**
 * Created by noel on 11/23/16.
 */
public class Person {
    String name;
    int age;
    String address;
    String eyeColor;
    String occupation;

    public void enterName() {
        System.out.println("Please enter your name.");
        name = scanner.nextLine();
        System.out.printf("Welcome, %s\n", name);

    }


    public void enterAge() {
        System.out.println("Please enter your age.");
        age = Integer.parseInt(scanner.nextLine());
        System.out.printf("Age: %d\n", age);
    }


    public void enterAddress() {
        System.out.println("Please enter your address.?");
        address = scanner.nextLine();
        System.out.printf("Address: %s\n", address);

    }
    public void enterEyeColor() {
        System.out.println("Enter eye color.");
        eyeColor = scanner.nextLine();
        System.out.printf("Eye color: %s\n", eyeColor);
    }
    public void enteroccupation() {
        System.out.println("Enter your occupation.");
        occupation = scanner.nextLine();
        System.out.printf("Occupation: %s\n", occupation);
    }

    public static void saveInfo(Person person) throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(person);
        File f = new File("Info.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static Person loadInfo() throws FileNotFoundException {
        File f = new File("info.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        return p.parse(contents, Person.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
