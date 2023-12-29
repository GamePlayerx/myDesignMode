package com.xcc.designmode.no12.Facade;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade() {
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();
    }

    public void doABC() {
        this.systemA.doSomething();
        this.systemB.doSomething();
        this.systemC.doSomething();
    }

    public void doAB() {
        this.systemA.doSomething();
        this.systemB.doSomething();
    }
}
