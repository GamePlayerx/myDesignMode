package com.xcc.designmode.Iterator模式;

public interface Aggregate {

    /**
     * 在Aggregate接口中声明的方法只有一个iterator方法。该方法会生成一个用于遍历集合的迭代器。
     * 想要遍历集合中的元素时，可以调用iterator方法来生成一个实现了Iterator接口的类的实例。
     * @return
     */
    public abstract Iterator iterator();
}
