package com.xcc.designmode.no22.State;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class MainClass {
    public static void main(String[] args) {
        Person person = new Person();
        person.setHour(7);
        person.doSomething();
        person.setHour(12);
        person.doSomething();
        person.setHour(18);
        person.doSomething();
        person.setHour(14);
        person.doSomething();
    }
}
