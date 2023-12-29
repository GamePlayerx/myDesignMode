package com.xcc.designmode.no8.Strategy;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class AESStrategy implements Strategy{
    @Override
    public void encrypt() {
        System.out.println("执行AES加密！");
    }
}
