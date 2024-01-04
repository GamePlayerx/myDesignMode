package com.xcc.designmode.no20.TemplateMethod;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public abstract class MakeCar { // 组装车
    // 组装车头
    public abstract void makeHead();
    // 组装车身
    public abstract void makeBody();
    // 组装车尾
    public abstract void makeTail();

    public void make() {
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}
