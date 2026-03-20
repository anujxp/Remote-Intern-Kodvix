package org.example;

public class StaticVar {
    int a = 0;


    void doSomething(){
        Employee e = () -> {
            a = 8;
            System.out.println(a);
        };
    }
}
