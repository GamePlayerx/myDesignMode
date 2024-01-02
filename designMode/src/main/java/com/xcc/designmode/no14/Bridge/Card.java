package com.xcc.designmode.no14.Bridge;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Card extends Product{
    @Override
    public void make() {
        System.out.println("生产RTX4090显卡！");
    }

    @Override
    public void sell() {
        System.out.println("全线的显卡来了....");
    }
}
