package com.xcc.designmode.no4.SingletonPattern;

/**
 * 懒汉式
 *
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton02 {
    // 创建一个私有属性  静态
    private static Phone phone = null;

    // 如果为null 那么进去创建一个新对象 并赋值给phone
    public static Phone getPhone() {
        if (phone == null) {
            phone = new Phone();
        }
        return phone;
    }
}
