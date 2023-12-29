package com.xcc.designmode.no11.Proxy;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MainClass {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxySubject = new ProxySubject(subject);
        proxySubject.show();
    }
}
