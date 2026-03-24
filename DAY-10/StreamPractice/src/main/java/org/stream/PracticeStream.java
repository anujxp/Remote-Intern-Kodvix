package org.stream;

import java.util.List;
import java.util.stream.Collectors;

public class PracticeStream {
    public static void main(String[] args) {
        List<Student> list = St.students.stream().filter(s-> s.getDepartment().equals("BCA")).collect(Collectors.toList());
        System.out.println(list);
        List<String> names  = St.students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);
        St.students.stream().map(Student::getName).forEach(System.out::println);
    }
}
