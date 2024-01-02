package com.xcc.designmode.no14.Bridge;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("===显卡赚钱===");
        ClothingCorp card = new ClothingCorp(new Card());
        card.makeMoney();

        System.out.println("AMD========");
        ClothingCorp amd = new ClothingCorp(new AmdCard());
        amd.makeMoney();
    }
}
