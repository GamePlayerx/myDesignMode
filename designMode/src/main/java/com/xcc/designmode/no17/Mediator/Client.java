package com.xcc.designmode.no17.Mediator;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Client {
    public static void main(String[] args) {
        //中介
        MediatorStructure mediator = new MediatorStructure();

        //房主:向中介提供房屋信息、获得租客信息
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        //租客:向中介提供租房信息、获得房屋信息
        Tenant tenant = new Tenant("李四", mediator);

        //中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        //租客获得信息
        tenant.constact("听说你那里有三室的房主出租.....");
        //房主获得信息
        houseOwner.constact("是的!请问你需要租吗?");
    }
}
