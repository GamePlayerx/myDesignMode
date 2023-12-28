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
Fruit接口<br>
```java
public interface Fruit {
    public void get();
}
```
Apple、Banana<br>
```java
public class Apple implements Fruit{
    @Override
    public void get() {
        System.out.println("还是苹果好吃！");
    }
}

public class Banana implements Fruit{
    @Override
    public void get() {
        System.out.println("香蕉味道还行！");
    }
}
```
Factory工厂接口<br>
```java
public interface Factory {
    Fruit created(Class s);
}
```
不同的实现类<br>
```java
public class FactoryBeijingImpl implements Factory{
    @Override
    public Fruit created(Class s) {
        System.out.println("北京工厂！");
        try {
            return (Fruit) s.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

public class FactoryShanghaiImpl implements Factory{
    @Override
    public Fruit created(Class s) {
        System.out.println("上海工厂！");
        try {
            return (Fruit) s.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
```
测试<br>
```java
public class MainClass {
    public static void main(String[] args) {
        Factory shanghaiFactory = new FactoryShanghaiImpl();
        Factory beijingFactory = new FactoryBeijingImpl();

        Fruit apple = shanghaiFactory.created(Apple.class);
        apple.get();

        Fruit banana = beijingFactory.created(Banana.class);
        banana.get();
    }
}
```

## 4、单例模式

### 声明是单例模式

单例模式（Singleton Pattern）是Java中最简单的设计模式之一。这种类型的模式属于创建型模式，
它提供了一种创建对象的最佳方式。这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保
只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

注意：<br>
+ 1、单例类只能有一个实例。
+ 2、单例类必须自己创建自己的唯一实例。
+ 3、单例类必须给所有其他对象提供这一实例。

### 单例模式分类
+ 1、饿汉式
+ 2、懒汉式

Phone类<br>
```java
public class Phone {
    public void get() {
        System.out.println("RedmiK70Pro");
    }
}
```

饿汉式<br>
```java
public class Singleton01 {
    // 创建一个私有属性  静态
    private static Phone phone = new Phone();

    public static Phone getPhone() {
        return phone;
    }
}
```
懒汉式<br>
```java
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
```

### 多种实现方式

#### 懒汉式，线程不安全
**是否Lazy初始化**：是<br>
**是否多线程安全**：否<br>
**实现难度**：易<br>
**描述**：这种方式是最进步的实现方式，这种实现最大的问题角色不支持多线程。因为没有加锁synchronized,
所以严格意义上它并不算单例模式。这种方式lazy loading很明显，不要求线程安全，在多线程不能正常工作。<br>
```java
public class Singleton03 {
    private static Singleton03 instance;
    private Singleton03() {}

    public static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03();
        }
        return instance;
    }
}
```

#### 懒汉式，线程安全
**是否Lazy初始化**：是<br>
**是否多线程安全**：是<br>
**实现难度**：易<br>
**描述**：这种方式具备很好的lazy loading，能够在多线程中很好的工作，但是，效率很低，99%情况下不需要同步。<br>
优点：第一次调用才初始化，避免内存浪费<br>
缺点：必须加锁synchronized才能保证单例，但加锁会影响效率。<br>
getInstance()的性能对应程序不是很关键（该方法使用不能太频繁）。<br>
```java
public class Singleton04 {
    private static Singleton04 instance;
    private Singleton04() {}

    public static synchronized Singleton04 getInstance() {
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }
}
```
#### 饿汉式
**是否Lazy初始化**：否<br>
**是否多线程安全**：是<br>
**实现难度**：易<br>
**描述**：这种方式比较常用，但容易产生垃圾对象。<br>
优点：没有加锁，执行效率会提高。<br>
缺点：类加载时就初始化，浪费内存。<br>
它基于classloader机制避免了多线程的同步问题，不过，instance在类装载时就实例化，
虽然导致类装载的原因有很多种，在单例模式种大多数都是调用getInstance方法，但是有不能确定有其他
的方式（或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到lazy loading的效果。<br>
```java
public class Singleton05 {
    private static Singleton05 instance = new Singleton05();
    private Singleton05() {}
    public static Singleton05 getInstance() {
        return instance;
    }
}
```
#### 双检锁/双重校验锁（DCL，即double-checked locking）
**是否Lazy初始化**：是<br>
**是否多线程安全**：是<br>
**实现难度**：较复杂<br>
**描述**：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。<br>
getInstance()的性能对应用程序很关键。<br>
```java
public class Singleton06 {
    private volatile static Singleton06 singleton06;
    private Singleton06() {}
    public static Singleton06 getSingleton06() {
        if (singleton06 == null) {
            synchronized (Singleton06.class) {
                if (singleton06 == null) {
                    singleton06 = new Singleton06();
                }
            }
        }
        return singleton06;
    }
}
```
#### 登记式/静态内部类
**是否Lazy初始化**：是<br>
**是否多线程安全**：是<br>
**实现难度**：一般<br>
**描述**：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，
应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，
它跟第 3 种方式不同的是：第 3 种方式只要 Singleton 类被装载了，那么 instance 
就会被实例化（没有达到 lazy loading 效果），而这种方式是 Singleton 类被装载了，
instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，
只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，
从而实例化 instance。想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，
另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他
的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。这个时候，
这种方式相比第 3 种方式就显得很合理。

```java

```
#### 枚举
**是否Lazy初始化**：否<br>
**是否多线程安全**：是<br>
**实现难度**：易<br>
**描述**：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。<br>
这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，
防止反序列化重新创建新的对象，绝对防止多次实例化。
```java
public enum Singleton08 {
    INSTANCE;
    public void whateverMethod() {
    }
}
```














