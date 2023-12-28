package com.xcc.designmode.no6.Builder;

/**
 * 房子
 *
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class House {
    // 地板
    private String floor;
    // 墙
    private String wall;
    // 屋顶
    private String housetop;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getHousetop() {
        return housetop;
    }

    public void setHousetop(String housetop) {
        this.housetop = housetop;
    }
}
