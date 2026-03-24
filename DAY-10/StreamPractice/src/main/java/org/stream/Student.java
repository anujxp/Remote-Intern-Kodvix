package org.stream;

import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int age;
    String department; // CS, BCA, Bio
    double percentage;

    public Student(String name, int age, String department, double percentage) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.percentage = percentage;
    }

    public String getDepartment() {
        return department;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

class St {
    public static List<Student> students = Arrays.asList(
            new Student("Anuj", 21, "BCA", 85.5),
            new Student("Vijay", 22, "CS", 70.0),
            new Student("Amit", 20, "BCA", 92.0),
            new Student("Sonal", 21, "Bio", 88.0),
            new Student("Rahul", 23, "CS", 65.5),
            new Student("Priya", 20, "BCA", 78.5)
    );

}