package com.xcc.designmode.no15.Adapter;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class MainClass {
    public static void main(String[] args) {
        Adapter2 adapter2 = new Adapter2(new Current());
        adapter2.use18V();
        Adapter adapter = new Adapter();
        adapter.use18V();

        AdapterClient adapterClient = new AdapterClient();
        adapterClient.recordLog();
    }
}
