package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by noel on 11/23/16.
 */
public class ReadWriteJson {
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setName("Noel Aniekan");
        p.setAge(30);
        p.setAddress("1350 Nicollet Ave");
        p.setEyeColor("Brown");
        p.setOccupation("Hacker");

        File f = new File("person.json");

        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(p);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();

        Scanner s = new Scanner(f);
        s.useDelimiter("//Z");
        String contents = s.next();
        JsonParser parser = new JsonParser();
        Person p2 = parser.parse(contents, Person.class);

        System.out.println(p2.getName() + " " + p2.getAge());
    }
}
