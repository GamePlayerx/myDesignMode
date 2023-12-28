package com.xcc.designmode.no6.Builder;

/**
 * 平方工程队
 *
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class PingFangBuilder implements HouseBuilder {
    House house = new House();

    public void makeFloor() {
        house.setFloor("平房-->地板");
    }

    public void makeHousetop() {
        house.setHousetop("平房-->房顶");
    }

    public void makeWall() {
        house.setWall("平房-->墙");
    }

    public House getHouse() {
        return house;
    }

}