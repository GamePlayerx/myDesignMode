package com.xcc.designmode.no14.Bridge;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class ClothingCorp extends Corp{
    public ClothingCorp(Product product) {
        super(product);
    }

    public void makeMoney() {
        super.makeMoney();
        System.out.println("赚钱了。。。。。。。。");
    }
}
