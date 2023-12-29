package com.xcc.designmode.no8.Strategy;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MD5Strategy implements Strategy{
    @Override
    public void encrypt() {
        System.out.println("执行MD5加密！");
    }
}
