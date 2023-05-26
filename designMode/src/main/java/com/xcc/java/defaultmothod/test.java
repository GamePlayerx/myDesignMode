package com.xcc.java.defaultmothod;

/**
 * 默认方法
 * 默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
 * 我们只需要在方法名前加上default关键字即可实现默认方法
 */
public class test {

    /**
     * 为什么要有这个特性呢？
     * 实现，之前的接口是个双刃剑，好处是，面向抽象而不是面向具体编程，
     * 缺陷是，当需要修改接口时候，需要修改全部实现改接口的类。
     * 所以默认方法，是为了解决接口的修改与现有的实现不兼容的问题。
     *
     * 举个例子：
     * public interface byd {
     *     default void print() {
     *         System.out.println("我是比亚迪的电动车，海豹");
     *     }
     * }
     *
     * 多个默认方法
     * 一个接口有默认方法，考虑这样的情况，一个类实现了多个接口，且这些接口有相同的默认方法，以下实例说明了这种情况的解决方法：
     * public interface byd {
     *     default void print() {
     *         System.out.println("我是比亚迪的电动车，海豹");
     *     }
     * }
     * public interface tesla {
     *     default void print() {
     *         System.out.println("我是特斯拉的韭菜收割机，model3");
     *     }
     * }
     *第一个解决方案是创建自己的默认方法，来覆盖重写接口的默认方法：
     * public class Car implements byd, tesla {
     *     @Override
     *     default void print() {
     *         System.out.println("我们都是电动车");
     *     }
     * }
     * 第二个解决方案可以使用super来调用指定接口的默认方法：
     * public class Car implements byd, tesla {
     *     @Override
     *     default void print() {
     *         tesla.super.print();
     *     }
     * }
     *
     * 静态默认方法
     * public interface byd {
     *     default void print() {
     *         System.out.println("我是比亚迪最新的电动车仰望u9！");
     *     }
     *     // 静态方法
     *     static void jump() {
     *         System.out.println("我有个绝活可以原地掉头！");
     *     }
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
        byd byd = new Car();
        byd.print();
    }
}

interface byd {
    default void print() {
        System.out.println("我是比亚迪最新的电动跑车仰望u9");
    }

    static void jump() {
        System.out.println("我有个绝活可以原地掉头！");
    }
}

interface tesla {
    default void print() {
        System.out.println("我是特斯拉最新的电动车modelY");
    }
}

class Car implements byd, tesla {

    @Override
    public void print() {
//        byd.super.print();
        tesla.super.print();
        byd.jump();
        System.out.println("我们都是电动车！");
    }
}


