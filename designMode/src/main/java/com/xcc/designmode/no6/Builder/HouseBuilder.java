package com.xcc.designmode.no6.Builder;

/**
 * 工程队
 *
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public interface HouseBuilder {
    //修地板
    public void makeFloor();
    //修墙
    public void makeWall();
    //修屋顶
    public void makeHousetop();
    public House getHouse();
}
