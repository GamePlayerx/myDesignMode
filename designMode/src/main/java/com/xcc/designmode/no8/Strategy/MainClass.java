package com.xcc.designmode.no8.Strategy;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MainClass {
    public static void main(String[] args) {
        Strategy strategy = new MD5Strategy();
        strategy.encrypt();

        Context context = new Context(new AESStrategy());
        context.encrypt();
    }
}
