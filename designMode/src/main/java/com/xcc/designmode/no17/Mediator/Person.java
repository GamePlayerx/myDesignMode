package com.xcc.designmode.no17.Mediator;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Person {
    String name;
    Mediator mediator;
    Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
