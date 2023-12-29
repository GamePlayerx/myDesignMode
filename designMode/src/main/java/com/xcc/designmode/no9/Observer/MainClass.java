package com.xcc.designmode.no9.Observer;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MainClass {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123");
        user.addObserver(new MyObServer());
        user.setUsername("小黑");
        user.setPassword("456");
    }
}
