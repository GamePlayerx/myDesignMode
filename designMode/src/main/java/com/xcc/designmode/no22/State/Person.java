package com.xcc.designmode.no22.State;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class Person {
    private int hour;

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    public void doSomething() {
        if (hour == 7) {
            System.out.println("吃早饭！");
        } else if (hour == 12) {
            System.out.println("吃午饭！");
        } else if (hour == 18) {
            System.out.println("吃晚饭！");
        } else {
            System.out.println(hour + "未定义。。。。。。");
        }
    }
}
