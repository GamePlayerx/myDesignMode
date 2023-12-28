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

## 2、工厂方法模式

### 什么是工厂方法模式

工厂方法模式同样属于类的创建型模式又被称为多态工厂模式。<br>
工厂方法模式的意义是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类当中。
核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，仅负责具体工厂子类必须实现的接口，
这样进一步抽象化的好处是使得工厂方法模式可以使系统再不修改具体工厂角色的情况下引进新的产品。<br>

### 模式中包含的角色

+ 1、抽象工厂（Creator）角色工厂方法模式的核心，任何工厂类都必须实现这个接口。
+ 2、具体工厂（Concrete Creator）角色具体工厂类是抽象工厂的一个实现，负责实例化产品对象。
+ 3、抽象（Product）角色工厂方法模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
+ 4、具体产品（Concrete Product）角色工厂方法模式所创建的觉他实例对象。

### 工厂方法模式和简单工厂模式比较

工厂方法模式与简单工厂模式再结构上的差不多。工厂方法类的核心是一个抽象工厂类，而简单工厂模式把核心放再一个具体类上。<br>
工厂方法模式之所以有一个别名叫多态性工厂模式是因为具体工厂类都有共同的接口，或者有共同的抽象父类。<br>
当系统扩展需要添加新的产品对象时，仅仅需要添加一个具体对象以及一个具体工厂对象，原有工厂对象不需要进行任何修改，
也不需要修改客户端，很好的符合了“开发-封闭”原则。而简单工厂模式在添加新产品对象后不得不修改工厂方法，扩展性不好。<br>
工厂方法模式退化后可以演变成简单工厂模式。

实例<br>
需要一个Fruit接口<br>
```java
public interface Fruit {
    public void get();
}
```
接口的实现类<br>
```java
public class Apple implements Fruit {
    public void get() {
        System.out.println("好吃的苹果！");
    }
}

public class Banana implements Fruit{
    @Override
    public void get() {
        System.out.println("Banana!");
    }
}

public class Orange implements Fruit {
    @Override
    public void get() {
        System.out.println("orange");
    }
}

```
工厂的接口类Factory（这里用的泛型方便自己选择要创建的实体类）<br>
```java
public interface Factory {
    Fruit create(Class s);
}
```
接口Factory的实现类<br>
```java
public class FactoryImpl implements Factory{
    @Override
    public Fruit create(Class s) {
        try {
            return (Fruit) s.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化失败！");
        }
    }
}
```
最后的测试<br>
```java
public class MainClass {
    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
        Fruit apple = factory.create(Apple.class);
        apple.get();
        Fruit banana = factory.create(Banana.class);
        banana.get();
        Fruit orange = factory.create(Orange.class);
        orange.get();
    }
}
```

## 3、抽象工厂模式

### 什么是抽象工厂模式

抽象工厂模式是所有形态的工厂模式中最为抽象和最据一般性的。抽象工厂模式可以向客户端提供一个接口，
使得客户端在不必要指定产品的具体类型的情况下，能够创建多个产品族的产品对象。

### 模式中包含的角色

+ 1、抽象工厂（Creator）角色的抽象工厂模式的核心，包含对多个产品结构的声明，任何工厂类都必须实现这个接口。
+ 2、具体工厂（Concrete Creator）角色的具体工厂类是抽象工厂的一个实现，负责实例化某个产品族中的产品对象。
+ 3、抽象（Product）角色的抽象模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
+ 4、具体产品（Concrete Product）角色的抽象模式所创建的具体实例对象的总结抽象工厂中方法对应产品结构，具体工厂对应产品族。

实例<br>





















