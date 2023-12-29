package com.xcc.designmode.no10.Flyweight;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MainClass {
    public static void main(String[] args) {
        LoginUser login = LoginUserFactory.getLoginUser("a");
        System.out.println("login.getUsername() = " + login.getUsername());
        System.out.println("login.getPassword() = " + login.getPassword());
    }
}
