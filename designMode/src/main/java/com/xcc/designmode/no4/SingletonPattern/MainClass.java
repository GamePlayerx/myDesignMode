package com.xcc.designmode.no4.SingletonPattern;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class MainClass {
    public static void main(String[] args) {
        Phone phone1 = Singleton01.getPhone();
        Phone phone2 = Singleton01.getPhone();

        phone1.get();
        phone2.get();

        // 在Java中 == 判断指向内存的引用 如果引用一样  对象肯定是同一个
        System.out.println(phone1 == phone2);

        Phone phone3 = Singleton02.getPhone();
        Phone phone4 = Singleton02.getPhone();

        phone3.get();
        phone4.get();

        System.out.println(phone3 == phone4);
    }
}
