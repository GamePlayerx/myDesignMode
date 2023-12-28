package com.xcc.designmode.no6.Builder;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class HouseDirector {
    public void makeHouse(HouseBuilder builder) {
        builder.makeFloor();
        builder.makeWall();
        builder.makeHousetop();
    }
}
