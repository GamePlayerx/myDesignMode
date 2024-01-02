package com.xcc.designmode.no17.Mediator;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class Tenant extends Person{  // 房客
    Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 与中介者联系
    public void constact(String message) {
       mediator.constact(message, this);
    }

    // 获取信息
    public void getMessage(String message) {
        System.out.println("租房者：" + name + "， 获得信息：" + message);
    }
}
