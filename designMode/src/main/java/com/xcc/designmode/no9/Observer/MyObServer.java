package com.xcc.designmode.no9.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MyObServer implements Observer {
    /**
     *
     * @param o     修改之前的
     * @param arg   调用：notifyObservers的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("对象发生变化！");
        User user = (User)o;
        System.out.println("user.getUsername()===" + user.getUsername());
        System.out.println("user.getPassword()===" + user.getPassword());
        System.out.println("o = " + o);
        System.out.println("arg = " + arg);
    }
}
