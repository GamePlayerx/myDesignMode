package com.xcc.designmode.no5.Prototype;

import java.util.Arrays;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class MainClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        person1.setName("小明");
        person1.setAge(26);
        person1.setSex("男");
        person1.setHobby(Arrays.asList("鬼泣5", "艾尔登法环", "荒野大镖客", "战神"));

        Person person2 = (Person) person1.clone();

        System.out.println(person1 == person2);

        System.out.println("person1.getName() = " + person1.getName());
        System.out.println("person1.getAge() = " + person1.getAge());
        System.out.println("person1.getSex() = " + person1.getSex());
        System.out.println("person1.getHobby() = " + person1.getHobby());

        System.out.println("person2.getName() = " + person2.getName());
        System.out.println("person2.getAge() = " + person2.getAge());
        System.out.println("person2.getSex() = " + person2.getSex());
        System.out.println("person2.getHobby() = " + person2.getHobby());
    }
}
