package com.xcc.designmode.no14.Bridge;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class AmdCard extends Product{
    @Override
    public void make() {
        System.out.println("生产7900x显卡！");
    }

    @Override
    public void sell() {
        System.out.println("AMD YES YES YES");
    }
}
