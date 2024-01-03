package com.xcc.designmode.no19.Iterator;


/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/3
 */
public class MainClass {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("黑神话：悟空");
        list.add("艾尔登法环");
        list.add("荒野大镖客");
        list.add("鬼泣");
        list.add("战神");
        list.add("极限国度");
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            String name = String.valueOf(iter.next());
            System.out.println("Name : " + name);
        }
    }
}
