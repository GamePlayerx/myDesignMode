package com.xcc.designmode.no7.Decorator;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MainClass {
    public static void main(String[] args) {
        Car xiaomi = new XiaoMiCar();
        xiaomi.show();

        Car huawei = new HuaWeiCar();
        huawei.show();
    }
}
