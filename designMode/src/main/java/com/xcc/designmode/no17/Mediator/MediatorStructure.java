package com.xcc.designmode.no17.Mediator;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class MediatorStructure extends Mediator{ // 具体中介者对象：中介结构
    //首先中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void constact(String message, Person person) {
        if(person == houseOwner){          //如果是房主，则租房者获得信息
            tenant.getMessage(message);
        }
        else{       //反之则是获得房主信息
            houseOwner.getMessage(message);
        }
    }
}
