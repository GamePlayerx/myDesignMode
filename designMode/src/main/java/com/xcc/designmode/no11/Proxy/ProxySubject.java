package com.xcc.designmode.no11.Proxy;

import javax.swing.plaf.PanelUI;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class ProxySubject implements Subject {
    Subject subject = null;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void show() {
        see();
        subject.show();
        look();
    }

    public void look() {
        System.out.println("星穹铁道，开启！");
    }

    public void see() {
        System.out.println("今天的崩坏三是无敌的！");
    }
}
