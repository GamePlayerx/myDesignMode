# myDesignMode
设计模式的总结

## 1、简单工厂模式

### 什么是简单工厂模式

简单工厂模式属于类的创建型模式，又叫做静态工厂方法模式。通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

### 模式中包含的角色

+ 1、工厂（Creator）角色简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类可以被外界直接调用，创建所需的产品对象。
+ 2、抽象（Product）角色简单工厂模式所常见的所有对象的父类，它负责描述所有实例所共有的公共接口。
+ 3、具体产品（Concrete Product）角色简单工厂模式所创建的具体实例对象。

### 简单工厂模式的优缺点

在这个模式中，工厂类是整个模式的关键所在。它包含必要的判断逻辑，能够根据外界给定的信息，
决定究竟应该创建哪个具体类的对象。用户在使用时可以直接根据工厂类去创建所需的实例，
而无需了解这些对象是如何创建以及如何组织的。有利于整个软件体系结构的优化。

不难发现，简单工厂模式的缺点也正体现在其工厂类上，由于工厂类集中了所有实例的创建逻辑，
所以“高内聚”方面做的并不好。另外，当系统中的具体产品类不断增多时，
可能会出现要求工厂类也要做相应的修改， 扩展性并不很好。

实例：<br>

创建一个Fruit里面就是一个get方法<br>
```java
public interface Fruit {
    public void get();
}
```

创建两个类Apple、Orange实现Fruit中的方法<br>
```java
public class Apple implements Fruit{
    public void get() {
        System.out.println("好吃的苹果！");
    }
}

public class Orange implements Fruit{
    public void get() {
        System.out.println("橘子好吃！");
    }
}
```

然后创建一个工厂方法FruitFactory<br>
```java
public class FruitFactory {
    /**
     * 自己选择创建谁
     */
    public static Fruit get(Class c) {
        try {
            return (Fruit) c.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化失败！");
        }
    }
}
```

最后写个测试类测试一下<br>
```java
public class MianClass {
    public static void main(String[] args) {
        Fruit apple = FruitFactory.get(Apple.class);
        apple.get();
        Fruit orange = FruitFactory.get(Orange.class);
        orange.get();
    }
}
```
