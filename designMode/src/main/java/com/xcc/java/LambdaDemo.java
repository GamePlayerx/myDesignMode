package com.xcc.java;

/**
 * Lambda表达式特征：
 * 1、可选类型声明：不需要声明参数类型，编辑器可以统一识别参数值。
 * 2、可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 3、可选的大括号：如果主体包含一个语句，就不需要使用大括号。
 * 4、可选的返回关键字：如果主体只有一个表达式返回值编译器回自动返回值，大括号需要指定表达式返回了一个数值。
 *
 * 简单举个例子：
 * 1、不需要参数，返回值为5
 * () -> 5
 *
 * 2、接收一个参数（数字类型），返回其2倍的值
 * x -> 2 * x
 *
 * 3、接受2个参数（数字），并返回他们的差值
 * (x, y) -> x - y
 *
 * 4、接收2个int类整数，返回他们的和
 * (int x, int y) -> x + y
 *
 * 5、接受一个string对象，并在控制台打印，不返回任何值（看起来像是返回void）
 * (String s) -> System.out.println(s)
 */
public class LambdaDemo {

    final static String salutation = "Hello! ";

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号及返回语句
        MathOperation multiplication = (int a, int b) -> {return a * b;};

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambdaDemo.operate(10,5, addition));
        System.out.println("10 - 5 = " + lambdaDemo.operate(10,5, subtraction));
        System.out.println("10 x 5 = " + lambdaDemo.operate(10,5, multiplication));
        System.out.println("10 / 5 = " + lambdaDemo.operate(10,5, division));

        // 不用括号
        GreetingService greetingService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetingService2 = (message) ->
                System.out.println("Hi " + message);

        greetingService1.sayMessage("World");
        greetingService2.sayMessage("Java");

        /**
         * 使用Lambda表达式需要注意的两点：
         * 1、Lambda表达式主要用来定义行内执行的方法类型接口（例如，一个简单方法接口）。
         * 在上面的例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法，
         * 然后我们定义了operation的执行。
         *
         * 2、Lambda表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
         */

        GreetingService greetingService3 = message ->
                System.out.println(salutation + message);
        greetingService3.sayMessage("Spring");

        final int num = 2;
        Converter<Integer, String> s = (param) -> {
            System.out.println(String.valueOf(param + num));
        };
        s.convert(1);



    }

}
