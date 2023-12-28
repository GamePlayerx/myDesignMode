package com.xcc.designmode.no4.SingletonPattern;

/**
 * 饿汉式
 * 单例模式：每次都是同一个对象 对象以及缓存在内存中了
 *
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
public class Singleton01 {
    // 创建一个私有属性  静态
    private static Phone phone = new Phone();

    public static Phone getPhone() {
        return phone;
    }
}
