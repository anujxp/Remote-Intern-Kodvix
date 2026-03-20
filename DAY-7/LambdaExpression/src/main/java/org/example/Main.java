package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public interface Main{
    public static void main(String[] args) {
        Employee emp = ()-> System.out.println("hello world!..");
        emp.hello();
        Runnable r = ()-> {

            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i+"" + Thread.currentThread());
            }
        };
        Thread ch = new Thread(r);
        Thread ch1 = new Thread(r);
        ch.setName("heelooo");
        ch.start();
        ch1.start();
    }
}