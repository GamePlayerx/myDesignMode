package com.xcc.designmode.no6.Builder;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class MainClass {
    public static void main(String[] args) {
        //		//客户直接造房子
//		House house = new House();
//		house.setFloor("地板");
//		house.setWall("墙");
//		house.setHousetop("屋顶");


        //由工程队来修
        HouseBuilder builder = new GongyuBuilder();
        //设计者来做
        HouseDirector director = new HouseDirector();
        director.makeHouse(builder);

        House house = builder.getHouse();
        System.out.println(house.getFloor());
        System.out.println(house.getWall());
        System.out.println(house.getHousetop());

        HouseBuilder builder1 = new PingFangBuilder();
        director.makeHouse(builder1);

        House house1 = builder1.getHouse();
        System.out.println(house1.getFloor());
        System.out.println(house1.getWall());
        System.out.println(house1.getHousetop());
    }
}
