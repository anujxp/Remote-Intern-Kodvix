package org.example;

import java.util.function.Predicate;

public class PredeicateExample {
    public static void main(String[] args) {
        Predicate<Integer> salaryGreaterThan100k = x -> x > 100000;
        // Using .test() to evaluate the condition
        System.out.println(salaryGreaterThan100k.test(150000)); // Output: true
        System.out.println(salaryGreaterThan100k.test(50000));  // Output: false
        Predicate<String> startsWithV = s -> s.toLowerCase().startsWith("v");

        System.out.println(startsWithV.test("Vipul")); // Output: true
        System.out.println(startsWithV.test("Hello")); // Output: false
    }
}

