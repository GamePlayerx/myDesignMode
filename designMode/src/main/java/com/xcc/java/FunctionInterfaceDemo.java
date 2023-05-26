package com.xcc.java;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * 函数式接口
 * 函数式接口（Function Interface）就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 * 函数式接口可以被隐式转换为lambda表达式。
 * Lambda表达式和方法引用（实际上也可以是Lambda表达式）上。
 *
 * 一般可以这样定义：
 * @FunctionalInterface
 * interface GreetingService {
 *     void sayMessage(String message);
 * }
 *
 * 那么就可以使用Lambda表达式来表示该接口的一个实现：
 * GreetingService greetingService1 = message -> System.out.println("Hello " + message);
 */
public class FunctionInterfaceDemo {

    /**
     * Predicate<T>接口是一个函数式接口，它接受一个输入参数T，返回一个布尔值结果。
     * 该接口包含多种默认方法来将Predicate组合其他复杂的逻辑（比如：与， 或， 非）
     * 该接口用于测试对象是true或false
     *
     * @param list
     * @param predicate
     */
    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + "");
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // Predicate<Integer> predicate = n -> true
        // n是一个参数传递到Predicate接口的test方法
        // n如果存在则test方法返回true
        System.out.println("输出所有数据：");

        // 传递参数n
        eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n是一个参数传递带Predicate接口的test方法
        // 如果n%2为0test方法返回true
        System.out.println("输出使用偶数：");
        eval(list, n -> n%2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 4
        // n是一个参数传递到Predicate接口的test方法
        // 如果n大于4test方法返回true
        System.out.println("输出大于4的所有数字：");
        eval(list, n -> n > 4);
    }

}
