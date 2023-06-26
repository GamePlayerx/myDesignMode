package com.xcc.designmode.Iterator模式;

/**
 * 声明两个方法，即判断是否存在下一个元素的hasNext方法，和获取下一个元素next方法。
 */
public interface Iterator {

    /**
     * 当集合中存在下一个元素时，返回true；
     * 当集合不存在下一个元素时，返回false。
     * hasNext方法主要用于循环终止条件。
     * @return
     */
    public abstract boolean hasNext();

    /**
     *
     * @return
     */
    public abstract Object next();
}
