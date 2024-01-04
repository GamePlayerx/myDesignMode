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
public class Singleton07 {
    private static class Singleton07Holder {
        private static final Singleton07 INSTANCE =new Singleton07();
    }
    private Singleton07() {}
    public static final Singleton07 getInstance() {
        return Singleton07Holder.INSTANCE;
    }
}
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
## 5、原型模式

### 什么是原型模式

Prototype模式是一种对象创建型模式，它采取复制原型对象的方法来创建对象的实例。
使用Prototype模式创建的实例，具有与原型一样的数据。

### 原型模式的特点
+ 1、由原型对象自身创建目标对象。也就是说，对象创建这易动作发自原型对象本身。
+ 2、目标对象是原型对象的一个克隆。也就是说，通过Prototype模式创建的对象，不仅仅与原型对象具有相同的结构，还与原型对象具有相同的值。
+ 3、根据对象克隆深度层次的不同，有浅度克隆的深度克隆。

### 使用场景

在创建对象的时候，我们不只是希望被创建的对象继承其基类的基本结构，还希望继承原型对象的数据。<br>
希望对目标对象的修改不影响既有的原型对象（深度克隆的时候可以完全互不影响）。<br>
隐藏克隆操作的细节。很多时候，对对象本身的克隆需要涉及到类本身的数据细节。<br>

实例：
```java
public class Person implements Cloneable{

    private String name;
    private int age;
    private String sex;
    private List<String> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```
测试：
```java
public class MainClass {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        person1.setName("小明");
        person1.setAge(26);
        person1.setSex("男");
        person1.setHobby(Arrays.asList("鬼泣5", "艾尔登法环", "荒野大镖客", "战神"));

        Person person2 = (Person) person1.clone();

        System.out.println(person1 == person2);

        System.out.println("person1.getName() = " + person1.getName());
        System.out.println("person1.getAge() = " + person1.getAge());
        System.out.println("person1.getSex() = " + person1.getSex());
        System.out.println("person1.getHobby() = " + person1.getHobby());

        System.out.println("person2.getName() = " + person2.getName());
        System.out.println("person2.getAge() = " + person2.getAge());
        System.out.println("person2.getSex() = " + person2.getSex());
        System.out.println("person2.getHobby() = " + person2.getHobby());
    }
}
```
## 6、建造者模式

### 什么是建造者模式

Builder模式也叫做建造者模式或者生成器模式。Builder模式是一种对象创建型模式之一，用来隐藏复合对象的创建过程，
它把复合对象的创建过程加以抽象，通过子类继承和重载的方式，动态地创建具有复合属性的对象。<br>
### Builder模式应用场景

+ 对象的创建：Builder模式是为对象的创建而涉及的模式。
+ 创建的是一个复合对象：被创建的对象为一个具有复合属性的复合对象。
+ 关注对象创建的各个部分的创建过程：不同的工厂（这里指builder生成器）对产品属性有不同的创建方法

实例<br>
```java
public class House {
    // 地板
    private String floor;
    // 墙
    private String wall;
    // 屋顶
    private String housetop;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getHousetop() {
        return housetop;
    }

    public void setHousetop(String housetop) {
        this.housetop = housetop;
    }
}
```
```java
public interface HouseBuilder {
    //修地板
    public void makeFloor();
    //修墙
    public void makeWall();
    //修屋顶
    public void makeHousetop();
    public House getHouse();
}
```
```java
public class PingFangBuilder implements HouseBuilder {
    House house = new House();

    public void makeFloor() {
        house.setFloor("平房-->地板");
    }

    public void makeHousetop() {
        house.setHousetop("平房-->房顶");
    }

    public void makeWall() {
        house.setWall("平房-->墙");
    }

    public House getHouse() {
        return house;
    }
}
```
```java
public class GongyuBuilder implements HouseBuilder{
    House house = new House();

    public House getHouse() {
        return house;
    }

    public void makeFloor() {
        house.setFloor("公寓-->地板");
    }

    public void makeHousetop() {
        house.setHousetop("公寓-->房顶");
    }

    public void makeWall() {
        house.setWall("公寓-->墙");
    }
}
```
```java
public class HouseDirector {
    public void makeHouse(HouseBuilder builder) {
        builder.makeFloor();
        builder.makeWall();
        builder.makeHousetop();
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        //由工程队来修
        HouseBuilder builder = new GongyuBuilder();
        //设计者来做
        HouseDirector director = new HouseDirector();
        director.makeHouse(builder);

        House house = builder.getHouse();
        System.out.println(house.getFloor());
        System.out.println(house.getWall());
        System.out.println(house.getHousetop());

        HouseBuilder builder1 = new PingFangBuilder();
        director.makeHouse(builder1);

        House house1 = builder1.getHouse();
        System.out.println(house1.getFloor());
        System.out.println(house1.getWall());
        System.out.println(house1.getHousetop());
    }
}
```
## 7、装饰模式

### 什么是装饰模式

装饰（Decorator）模式又叫做包装模式。通过一种客户端透明的方式来扩展对象的功能，是继承关系的一个替代方案。

### 装饰模式的角色

+ 抽象组件角色：一个抽象接口，是被装饰类和装饰类的父接口。
+ 具体组件角色：为抽象组件的实现类。
+ 抽象装饰角色：包含一个组件的引用，并定义了抽象组件一致的接口。
+ 具体装饰角色：为抽象装饰角色的实现类。负责具体的装饰。

实例：<br>
```java
public interface Car {
    public void show();
    public void run();
}
```
```java
public class XiaoMiCar implements Car{
    @Override
    public void show() {
        this.run();
        this.fly();
    }

    @Override
    public void run() {
        System.out.println("Are you ok!");
    }

    public void fly() {
        System.out.println("屌爆了");
    }
}
```
```java
public class HuaWeiCar implements Car{
    @Override
    public void show() {
        this.huawei();
        this.run();
    }

    @Override
    public void run() {
        System.out.println("一直领先！");
    }

    public void huawei() {
        System.out.println("遥遥领先！");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Car xiaomi = new XiaoMiCar();
        xiaomi.show();

        Car huawei = new HuaWeiCar();
        huawei.show();
    }
}
```

## 8、策略模式

### 什么是策略模式

Strategy模式也叫策略模式是行为模式之一，它对一系列的算法加以封装，为所以算法定义一个抽象的算法接口，并
通过继承该抽象算法接口对所以的算法加以封装和实现，具体的算法选择交由客户端决定（策略）。Strategy模式
主要用来平滑地处理算法的切换。

### 策略模式的角色

+ Strategy：策略（算法）抽象。
+ ConcreteStrategy各种策略（算法）的具体实现。
+ Context策略的外部封装类，或者说策略的容器类。根据不同策略执行不同的行为。策略由外部环境决定。

### 策略模式的优点和缺点

优点：<br>
1. 策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。
恰当使用继承可以把公共的代码移到父类里面，从而避免重复的代码。<br>
2. 策略模式提供了可以替换继承关系的办法。继承可以处理多种算法或行为。
如果不是用策略模式，那么使用算法或行为的环境类就可能会有一些子类，
每一个子类提供一个不同的算法或行为。但是，这样一来算法或行为的使用者就和算法或行为本身混在一起。
决定使用哪一种算法或采取哪一种行为的逻辑就和算法或行为的逻辑混合在一起，从而不可能再独立演化。
继承使得动态改变算法或行为变得不可能。<br>
3. 使用策略模式可以避免使用多重条件转移语句。多重转移语句不易维护，
它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，
统统列在一个多重转移语句里面，比使用继承的办法还要原始和落后。<br>

缺点：<br>
1. 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。
换言之，策略模式只适用于客户端知道所有的算法或行为的情况。<br>
2. 策略模式造成很多的策略类。有时候可以通过把依赖于环境的状态保存到客户端里面，
而将策略类设计成可共享的，这样策略类实例可以被不同客户端使用。
换言之，可以使用享元模式来减少对象的数量。<br>

实例：<br>
```java
public interface Strategy {
    // 加密
    public void encrypt();
}
```
```java
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void encrypt() {
        this.strategy.encrypt();
    }
}
```
```java
public class MD5Strategy implements Strategy{
    @Override
    public void encrypt() {
        System.out.println("执行MD5加密！");
    }
}
```
```java
public class AESStrategy implements Strategy{
    @Override
    public void encrypt() {
        System.out.println("执行AES加密！");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Strategy strategy = new MD5Strategy();
        strategy.encrypt();

        Context context = new Context(new AESStrategy());
        context.encrypt();
    }
}
```

## 9、观察者模式

### 什么是观察者模式

Observer模式是行为模式之一，它的作用是当作一个对象的状态发送变化时，能够主动通知其他管理对象，自动刷新对象状态。<br>
Observe模式提供给管理对象一种同步通信的手段，使某个对象与依赖它的其他对象之间保持状态同步。<br>

### 观察者模式的角色

Subject（被观察者）被观察的对象。当需要被观察的状态发生变化时，需要通知队列种所以观察者对象。Subject
需要维持（添加，删除，通知）一个观察者对象的队列列表。<br>
+ ConcreteSubject被观察者的具体实现。包含一些基本的属性状态及其他操作。
+ Observer（观察者）接口或抽象类。当Subject的状态发生变化时，Observer对象将通过一个callback函数得到通知。
+ ConcreteObserver观察者的具体实现。得到通知后将完成一些具体的业务逻辑处理。

### 观察者模式的典型应用

+ 侦听事件驱动程序设计中的外部事件
+ 侦听/监视某个对象的状态变化
+ 发布者/订阅者（publisher/subscriber）模型中，当一个外部事件（新的产品，消息的出现等等）被触发时，通知邮件列表中的订阅者

实例：<br
```java
public class User extends Observable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.setChanged();
        this.notifyObservers("username被修改了====" + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.setChanged();
        this.notifyObservers("password被修改了====" + password);
    }
}
```
```java
public class MyObServer implements Observer {
    /**
     *
     * @param o     修改之前的
     * @param arg   调用：notifyObservers的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("对象发生变化！");
        User user = (User)o;
        System.out.println("user.getUsername()===" + user.getUsername());
        System.out.println("user.getPassword()===" + user.getPassword());
        System.out.println("o = " + o);
        System.out.println("arg = " + arg);
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("小明");
        user.setPassword("123");
        user.addObserver(new MyObServer());
        user.setUsername("小黑");
        user.setPassword("456");
    }
}
```

## 享元模式

### 什么是享元模式

Flyweight模式也叫享元模式，是构造型模式之一，它通过其他类似对象共享数据来减少内存占用。<br>

### 10、享元模式的角色

+ 抽象享元角色：所以具体享元类的父类，规定一些需要实现的公共接口。
+ 具体享元角色：抽象享元角色的具体实现类，并实现了抽象享元角色规定的方法。
+ 享元工厂角色：负责创建和管理享元角色。

实例：<br>
```java
public class LoginUser {
    private String username;
    private String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
```
```java
public class LoginUserFactory {
    private static Map<String, LoginUser> pool = new HashMap<>();
    public LoginUserFactory() {
        pool = new HashMap<>();
    }
    public static LoginUser getLoginUser(String key) {
        LoginUser loginUser = pool.get(key);
        if (loginUser == null) {
            loginUser = new LoginUser("admin", "admin123");
            pool.put(key, loginUser);
        }
        return loginUser;
    }

    public static void setLoginUser(String key, LoginUser loginUser) {
        pool.put(key, loginUser);
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        LoginUser login = LoginUserFactory.getLoginUser("a");
        System.out.println("login.getUsername() = " + login.getUsername());
        System.out.println("login.getPassword() = " + login.getPassword());
    }
}
```

## 11、代理模式

### 什么是代理模式

Proxy模式又叫做代理模式，是构造型的设计模式之一，它可以为其他对象提供一种代理（Proxy）以控制对这个对象的访问。<br>
所谓代理，是指具有与代理元（被代理的对象）具有相同的接口的类，客户端必须通过代理与被代理的目标类交互，
而代理一般在交互的过程中（交互前后），进行某些特别的处理。<br>

### 代理模式的角色

+ subject（抽象主题角色）：真实主题与代理主题的共同接口。
+ RealSubject（真实主题角色）：定义了代理角色所代表的真实对象。
+ Proxy（代理主题角色）：含有对真实主题角色的引用，代理角色通常在将客户端调用传递给真主题对象之前或之后执行某些操作，而不是单纯返回真实的对象

### 动态代理

1. InvocationHandler接口
2. invoke方法
3. Proxy.newProxyInstance();

实例：<br>
```java
public interface Subject {
    public void show();
}
```
```java
public class RealSubject implements Subject{
    @Override
    public void show() {
        System.out.println("原神，启动");
    }
}
```
```java
public class ProxySubject implements Subject {
    Subject subject = null;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void show() {
        see();
        subject.show();
        look();
    }

    public void look() {
        System.out.println("星穹铁道，开启！");
    }

    public void see() {
        System.out.println("今天的崩坏三是无敌的！");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxySubject = new ProxySubject(subject);
        proxySubject.show();
    }
}
```

## 12、外观模式

### 什么是外观模式

Facade模式也叫外观模式.Facade模式为一组具有类似功能的类群，比如类库，子系统等等，提供一个一致
的简单的界面。这个一致的简单的界面被称作facade。

### 外观模式的角色

+ Facade为调用方定义简单的调用接口。
+ Clients调用者。通过Facade接口调用提供某功能的内部类群。
+ Packages功能提供者。指提供功能的类群（模块或子系统）

实例：<br>
```java
public class SystemA {
    public void doSomething() {
        System.out.println("与买桂花同载酒，终不似，古人游！");
    }
}
```
```java
public class SystemB {
    public void doSomething() {
        System.out.println("当你因为错过太阳而哭泣，那你又要错过群星");
    }
}
```
```java
public class SystemC {
    public void doSomething() {
        System.out.println("99.99%");
    }
}
```
```java
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade() {
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();
    }

    public void doABC() {
        this.systemA.doSomething();
        this.systemB.doSomething();
        this.systemC.doSomething();
    }

    public void doAB() {
        this.systemA.doSomething();
        this.systemB.doSomething();
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doABC();
    }
}
```
```java
public class MainClass1 {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doAB();
    }
}
```

## 13、组合模式

### 什么是组合模式

Composite模式也叫组合模式，是构造型的设计模式之一。通过递归手段老构造树形的对象结构，并可以通过一个
对象来访问整个对象数。

### 组合模式的角色

+ Component（树形机构的节点抽象）
+ 为所以的对象定义统一的接口（公共属性，行为等的定义）
+ 提供管理子节点对象的接口方法
+ 【可选】提供管理父节点对象的接口方法Leaf（树形结构的叶节点）
+ Component的实现子类
+ Composite（树形结构的枝节点）
+ Component的实现子类

实例：<br>
```java
public interface Employee {
    public void showEmployeeDetails();
}
```
```java
public class Developer implements Employee{
    private String name;
    private long empId;
    private String position;

    public Developer(String name, long empId, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}
```
```java
public class Manager implements Employee{
    private String name;
    private long empId;
    private String position;
    public Manager(String name, long empId, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println(name + " " + position);
    }
}
```
```java
public class CompanyDirectory implements Employee{
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        for (Employee employee : employeeList) {
            employee.showEmployeeDetails();
        }
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }
}

```
```java
public class MainClass {
    public static void main(String[] args) {
        Developer developer1 = new Developer("xcc", 26, "game");
        Developer developer2 = new Developer("qwe", 27, "player");
        CompanyDirectory companyDirectory1 = new CompanyDirectory();
        companyDirectory1.addEmployee(developer1);
        companyDirectory1.addEmployee(developer2);

        Manager manager1 = new Manager("today", 1,"weeking");
        Manager manager2 = new Manager("tomorrow", 7,"working");

        CompanyDirectory companyDirectory2 = new CompanyDirectory();
        companyDirectory2.addEmployee(manager1);
        companyDirectory2.addEmployee(manager2);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(companyDirectory1);
        directory.addEmployee(companyDirectory2);
        directory.showEmployeeDetails();
    }
}
```

## 14、桥接模式

### 什么是桥接模式

Bridge模式又叫做桥接模式，是构造型的设计模式之一。Bridge模式基于类的最小设计原则，通过使用封装，聚合
以及继承等行为来让不同的类承担不同的责任。它的主要特点是把抽象（abstraction）与行为实现（implementation）
分离开来，从而可以保持各部分的独立性以及应对它们的功能扩展。<br>

### 桥接模式的角色

+ Client：Bridge模式的使用者
+ Abstraction：抽象类接口（接口或抽象类）、维护对行为实现（Implementor）的引用
+ Refined Abstraction：Abstraction子类
+ Implementor：行为实现类接口（Abstraction接口定义了基于Implementor接口的更高层次的操作）
+ ConcreteImplementor：Implementor子类

实例：<br>
```java
public abstract class Product {
    // 不管什么产品，都要生产
    public abstract void make();
    // 不管什么产品，都要销售
    public abstract void sell();
}
```
```java
public class Card extends Product{
    @Override
    public void make() {
        System.out.println("生产RTX4090显卡！");
    }

    @Override
    public void sell() {
        System.out.println("全线的显卡来了....");
    }
}
```
```java
public class AmdCard extends Product{
    @Override
    public void make() {
        System.out.println("生产7900x显卡！");
    }

    @Override
    public void sell() {
        System.out.println("AMD YES YES YES");
    }
}
```
```java
public class Corp {
    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    public void makeMoney() {
        this.product.make();
        this.product.sell();
    }
}
```
```java
public class ClothingCorp extends Corp{
    public ClothingCorp(Product product) {
        super(product);
    }

    public void makeMoney() {
        super.makeMoney();
        System.out.println("赚钱了。。。。。。。。");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        System.out.println("===显卡赚钱===");
        ClothingCorp card = new ClothingCorp(new Card());
        card.makeMoney();

        System.out.println("AMD========");
        ClothingCorp amd = new ClothingCorp(new AmdCard());
        amd.makeMoney();
    }
}
```

## 15、适配器模式

### 什么是适配器模式

Adapter模式也叫适配器模式，是构造型模式之一，通过Adapter模式可以改变已有类（或外部类）的接口形式。<br>

定义：将一个接口转换为客户端所期待的接口，从而使两个接口不兼容的类可以在一起工作<br>

适配器模式还有各别名叫：Wrapper（包装器），顾名思义角色将目标类用一个新类包装一下，相当于在客户端与目标类
直接加了一层。IT世界有句俗语：没有什么问题是加一层不能解决的。<br>

通俗理解：类似与我们的转接头，比如国内220v，欧洲有的是230v，有的是110v，那么我们过去就需要对应的转接头才可以使用。

### 使用场景

在大规模的系统开发过程中，我们常常碰到诸如以下这些情况：我们需要实现某些功能，这些功能已有还不太成熟的一个或多个外部
组件，吐过我们组件重新开发这些功能会花费大量时间；所以很多情况下会选择暂时使用外部组件，以后再考虑随时替换。但这样一来，
会带来一个问题，随着对外部组件库的替换，可能需要对引用该外部组件的源代码进行大面积的修改，因此也极有可能引入新的问题。<br>

Adapter模式就是针对这中类似需求而提出来的。Adapter模式通过定义一个新的接口（对要实现的功能加以抽象），和一个实现
该接口的Adapter（适配器）类来透明地调用外部组件。这样替换外部组件时，最多只要修改几个Adapter类就可以了，其他
源代码都不会受到影响。


实例1：<br>
```java
public class Current {
    public void use220V() {
        System.out.println("使用220V电流！");
    }
}
```
```java
public class Adapter extends Current{
    public void use18V() {
        System.out.println("使用适配器");
        this.use220V();
    }
}
```
```java
public class Adapter2 {
    private Current current;
    public Adapter2(Current current) {
        this.current = current;
    }

    public void use18V() {
        System.out.println("使用适配器！");
        this.current.use220V();
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Adapter2 adapter2 = new Adapter2(new Current());
        adapter2.use18V();
        Adapter adapter = new Adapter();
        adapter.use18V();
    }
}
```

**案例2:**<br>

日志是适配器使用最多的一个场景：扩展使用不同的日志<br>
极大的增强了抽象的可扩展性，通过此模式，你可以随意扩展程序的功能，但却不需要修改接口。

**第一、确定目标接口**<br

系统原来的日志接口<br>
```java
public interface LogFactory {
    void debug(String tag, String message);
}
```

**第二、三方库接口及实现**<br>

下面是第三方提供的日志功能，但是其接口与正在使用的不兼容

```java
public interface NbLogger {
    void d(int priority, String message, Object... obj);
}

// 具体提供日志功能的实现类
public class NbLoggerImp implements NbLogger{
    @Override
    public void d(int priority, String message, Object... obj) {
        System.out.println(String.format("牛xlogger记录:%s", message));
    }
}
```

**第三、构建适配器类**<br>

这个类是适配器模式的核心，通过此类就可以将三方提供的接口转换为系统的目标接口<br>

```java
public class LogAdapter implements LogFactory{
    private NbLogger nbLogger;

    public LogAdapter(NbLogger nbLogger) {
        this.nbLogger = nbLogger;
    }

    @Override
    public void debug(String tag, String message) {
        Objects.requireNonNull(nbLogger);
        nbLogger.d(1, message);
    }
}
```
LogAdapter实现了系统的目标接口，，同时持有三方库NbLogger的引用。<br>

**客户端使用**<br>

```java
public class AdapterClient {
    public void recordLog() {
        LogFactory logFactory = new LogAdapter(new NbLoggerImp());
        logFactory.debug("测试", "logger打印log");
    }
}
```

## 16、解释器模式

### 什么是解释器模式

Interpreter模式也叫解释器模式，是行为模式之一，它是一种特殊的设计模式，它建立一个解释器，对于特定的计算机程序设计语言，用来
解释预先定义的文法。简单地说，Interpreter模式是一种简单的语法解释器架构。

### 解释器模式应用场景

当有一个语言需要解释执行并且你可将语言中的句子表示为一个抽象语法树时，可使用解释器模式。而当存在以下情况时该模式效果最好:<br>
该语法简单对于复杂的语法，语法的类层次变得庞大而无法管理。此时语法分析程序生成器这样的工具是更好的选择。它们无需构建
抽象语法树即可解释表达式，这样可以节省空间而且还可能节省时间。<br>
效率不是一个关键问题，最高效的解释器通常不是通过解释语法分析树实现的，而是首先将它们转换成另一种形式。例如，正则表达式
通常被转换成状态机。但即使在这种情况下，转换器仍可用解释器模式实现，该模式仍是有用的。<br>

### 解释器模式的角色

+ Context解释器上下文环境类。用来存储解释器的上下文环境，比如需要解释的语法等。
+ AbstractExpression 解释器抽象类。
+ ConcreteExpression解释器具体实现类。

实例:<br>
```java
public class Context {
    private String input;
    private int output;

    public Context(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
```
```java
public abstract class Expression {
    public abstract void interpret(Context context);
}
```
```java
public class MinusExpression extends Expression{
    @Override
    public void interpret(Context context) {
        System.out.println("自动递减！");
        String input = context.getInput();
        int inInput = Integer.parseInt(input);
        --inInput;
        context.setInput(String.valueOf(inInput));
        context.setOutput(inInput);
    }
}
```
```java
public class PlusExpression extends Expression{
    @Override
    public void interpret(Context context) {
        System.out.println("自动递增");
        String input = context.getInput();
        int inInput = Integer.parseInt(input);
        ++inInput;
        context.setInput(String.valueOf(inInput));
        context.setOutput(inInput);
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        String number = "26";
        Context context = new Context(number);

        List<Expression> list = new ArrayList<>();
        list.add(new PlusExpression());
        list.add(new PlusExpression());
        list.add(new PlusExpression());
        list.add(new MinusExpression());
        list.add(new MinusExpression());

        for (Expression ex : list) {
            ex.interpret(context);
            System.out.println(context.getOutput());
        }
    }
}
```

## 17、中介者模式

### 什么是中介者模式

Mediator模式也叫中介者模式，Mediator模式是行为模式之一，在Mediator模式中，类之间的交互行为被统一放在Mediator的对象中，对象
通过Mediator对象同其他对象交互，Mediator对象起着控制器的作用。<br>

### 中介者模式的角色

+ mediator 中介者类的抽象父类。
+ concreteMediator 具体的中介者类。
+ colleague 关联类的抽象父类。
+ concreteColleague 具体的关联类。

### 中介者模式的优点

1. 将系统按功能分割成更小的对象，符合类的最小设计原则
2. 对关联对象的集中控制
3. 减小类的耦合程度，明确类之间的相互关系：当类之间的关系过于复杂时，其中任何一个类的修改都会影响到其他类，不符合类的设计的开闭原则 ，而Mediator模式将原来相互依存的多对多的类之间的关系简化为Mediator控制类与其他关联类的一对多的关系，当其中一个类修改时，可以对其他关联类不产生影响（即使有修改，也集中在Mediator控制类）。
4. 有利于提高类的重用性

实例<br>
```java
public class Person {
    String name;
    Mediator mediator;
    Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}

```
```java
public abstract class Mediator { // 抽象中介者
    // 申明一个联络方法
    public abstract void constact(String message, Person person);
}
```
```java
public class HouseOwner extends Person{
    HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 与中介者联系
    public void constact(String message) {
        mediator.constact(message, this);
    }

    // 获取信息
    public void getMessage(String message) {
        System.out.println("房主：" + name + "，获得信息：" + message);
    }
}
```
```java
public class Tenant extends Person{  // 房客
    Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 与中介者联系
    public void constact(String message) {
       mediator.constact(message, this);
    }

    // 获取信息
    public void getMessage(String message) {
        System.out.println("租房者：" + name + "， 获得信息：" + message);
    }
}
```
```java
public class MediatorStructure extends Mediator{ // 具体中介者对象：中介结构
    //首先中介结构必须知道所有房主和租房者的信息
    private HouseOwner houseOwner;
    private Tenant tenant;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void constact(String message, Person person) {
        if(person == houseOwner){          //如果是房主，则租房者获得信息
            tenant.getMessage(message);
        }
        else{       //反之则是获得房主信息
            houseOwner.getMessage(message);
        }
    }
}
```
```java
public class Client {
    public static void main(String[] args) {
        //中介
        MediatorStructure mediator = new MediatorStructure();

        //房主:向中介提供房屋信息、获得租客信息
        HouseOwner houseOwner = new HouseOwner("张三", mediator);
        //租客:向中介提供租房信息、获得房屋信息
        Tenant tenant = new Tenant("李四", mediator);

        //中介结构要知道房主和租房者
        mediator.setHouseOwner(houseOwner);
        mediator.setTenant(tenant);

        //租客获得信息
        tenant.constact("听说你那里有三室的房主出租.....");
        //房主获得信息
        houseOwner.constact("是的!请问你需要租吗?");
    }
}
```

## 18、职责链模式

### 什么是职责链模式

Chain of Responsibility（CoR）模式也叫职责链模式或者职责连锁模式，是行为模式之一，该模式构造一系列分别担当不同
的职责的类的对象来共同完成一个任务，这些类的对象之间像链条一样紧密相连，所以被称作职责链模式。<br>

### 职责链模式的应用场景

**例1**：比如客户Client要完成一个任务，中国任务包括a，b，c，d四个部分。首先客户Client把任务交给A，A完成a部分之后，把任务交给B，B完成b
部分，.....直到D完成d部分。<br>

**例2**：比如政府部分的某项工作，县政府先完成自己能处理的部分，不能处理的部分交给省政府，省政府再完成自己职责范围内的部分，
不能处理的部分交给中央政府，中央政府最后完成该项工作。<br>

**例3**：软件窗口的消息 传播。<br>

**例4**：SERVLET容器的过滤器（Filter）框架实现。<br>

### 职责链模式的基本条件

要实现Chain of Responsibility模式，需要满足该模式的基本条件：<br>
1. 对象链的组织。需要将某任务的所有职责执行对象以链的形式加以组织。
2. 消息或请求的传递。将消息或请求沿着对象链传递，以让处于对象链中的对象得到处理机会。
3. 处于对象链中的对象的职责分配。不同的对象完成不同的职责。
4. 任务的完成。处于对象链的末尾的对象结束任务并停止消息或请求的继续传递。

### 职责链模式的角色

+ Handler   处理了欸的抽象父类
+ concreteHandler    具体的处理类

### 职责链模式的优缺点

优点：<br>
1. 责任的分担。每个类只需要处理自己该处理的工作（不该处理的传递给下一个对象完成），明确各类的责任范围，符合类的最小封装原则。
2. 可以根据需要自由组合工作流程。如工作流程发生变化，可以通过重新分配对象链便可适应新的工作流程。
3. 类与类之间可以以松耦合的形式加以组织。

缺点：<br>
因为处理时以链的形式再对象间传递消息，根据实现方式不同，有可能会影响处理的速度。

实例<br>
```java
public interface HandlerChain {
    void setNext(HandlerChain handler);
    void doChian();
}
```
```java
public class ConcreteHandlerA implements HandlerChain{
    private HandlerChain nextHandler;
    @Override
    public void setNext(HandlerChain handler) {
        this.nextHandler = handler;
    }

    @Override
    public void doChian() {
        System.out.println("处理请求A");
        this.nextHandler.doChian();
    }
}
```
```java
public class ConcreteHandlerB implements HandlerChain{
    private HandlerChain nextHandler;
    @Override
    public void setNext(HandlerChain handler) {
        this.nextHandler = handler;
    }

    @Override
    public void doChian() {
        System.out.println("处理请求B！");
        this.nextHandler.doChian();
    }
}
```
```java
public class ConcreteHandlerC implements HandlerChain{
    private HandlerChain nextHandler;
    @Override
    public void setNext(HandlerChain handler) {
        this.nextHandler = handler;
    }

    @Override
    public void doChian() {
        System.out.println("处理请求C！！");
        this.nextHandler.doChian();
    }
}
```
```java
public class ConcreteHandlerD implements HandlerChain{
    private HandlerChain nextHandler;
    @Override
    public void setNext(HandlerChain handler) {
        this.nextHandler = handler;
    }

    @Override
    public void doChian() {
        System.out.println("处理请求D！！！");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        // 创建处理器链
        List<HandlerChain> handlers = new ArrayList<>();
        handlers.add(new ConcreteHandlerA());
        handlers.add(new ConcreteHandlerB());
        handlers.add(new ConcreteHandlerC());
        handlers.add(new ConcreteHandlerD());

        // 处理器连接在一起
        for (int i = 0; i < handlers.size() - 1; i++) {
            HandlerChain currentHandler = handlers.get(i);
            HandlerChain nextHandler  = handlers.get(i + 1);
            currentHandler.setNext(nextHandler);
        }

        // 处理请求
        handlers.get(0).doChian();
    }
}
```

## 19、迭代模式

### 什么是迭代模式

Iterator模式也叫迭代模式，是行为模式之一，它把对容器中包含的内部对象的访问委让给外部类，使用Iterator（遍历）按顺序
进行访问的设计模式。<br>

### 不使用迭代模式的应用

1. 由容器自己实现顺序遍历。直接在容器类里直接添加顺序遍历方法
2. 让调用者自己实现遍历。直接暴露数据细节给外部

### 不使用迭代模式的缺点

1. 容器类承担了太多功能：一方面需要提供添加删除等本身应有的功能；一方面还需要提供遍历访问功能。
2. 往往容器在实现遍历的过程中，需要保存遍历状态，当跟元素的添加删除等功能夹杂在一起，很容易引起混乱和程序运行错误等。

### 使用迭代模式的应用

Iterator模式就是为了有效地处理按顺序进行遍历访问的一种设计模式，简单地说，Iterator模式提供一种有效的方法，可以屏蔽聚集
对象集合的容器类的实现细节，而能对容器内包含的对象元素按顺序进行有效的遍历访问。<br>

所有，Iterator模式的应用场景可以归纳为满足以下几个条件：<br>
+ 访问容器中包含的内部对象
+ 按顺序访问

### 迭代模式的角色

+ Iterator（迭代器接口）：该接口必须定义实现迭代功能的最小定义方法集比如提供hasNext()和next()方法。
+ ConcreteIterator（迭代器实现类）：迭代器接口Iterator的实现类。可以根据具体情况加以实现。
+ Aggregate（容器接口）：定义基本功能以及提供类似Iterator iterator()的方法。
+ concreteAggregate（容器实现类）：容器接口的实现类。必须实现Iterator iterator()方法。

### 迭代模式的优点

1. 实现功能分离，简化容器接口。让容器只实现本身的基本功能，把迭代功能委让给外部类实现，符合类的设计原则。
2. 英寸容器的实现细节。
3. 为容器或其子容器提供了一个统一的接口，一方面方便调用；另一方面使得调用者不必关注迭代器的实现细节。
4. 可以为容器或其子容器实现不同的迭代方法或多个迭代方法。

实例<br>
```java
public interface Iterator {
    boolean hasNext();
    Object next();
}
```
```java
public interface List {
    void add(String str);
    Iterator iterator();
}
```
```java
public class ArrayList implements List{
    public String[] names = new String[10];
    @Override
    public void add(String str) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                names[i] = str;
                break;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length && names[index] != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("黑神话：悟空");
        list.add("艾尔登法环");
        list.add("荒野大镖客");
        list.add("鬼泣");
        list.add("战神");
        list.add("极限国度");
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            String name = String.valueOf(iter.next());
            System.out.println("Name : " + name);
        }
    }
}
```

## 20、模板方法模式

### 什么是模板方法模式

Template Method模式也叫模板方法模式，是行为模式之一，它把具有特定步骤算法中的某些必要的处理委让给抽象方法，通过
子类继承对抽象方法的不同实现改变整个算法的行为。<br>

### 模板方法模式的应用场景

+ 具有统一的操作步骤或操作过程
+ 具有不同的操作细节
+ 存在多个具有同样操作步骤的应用场景，但某些具体的操作细节却各不相同

### 模板方法模式的角色

+ AbstractClass：抽象类的父类
+ ConcreteClass：具体的实现子类
+ templateMethod()：模板方法
+ method1()与method2()：具体步骤方法

实例<br>
```java
public abstract class MakeCar { // 组装车
    // 组装车头
    public abstract void makeHead();
    // 组装车身
    public abstract void makeBody();
    // 组装车尾
    public abstract void makeTail();

    public void make() {
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}
```
```java
public abstract class MakeGame {
    // 制作名字
    public abstract void makeName();
    // 制作音乐
    public abstract void makeMusic();
    // 制作画面
    public abstract void makeImage();
    // 制作引擎
    public abstract void makeEngine();

    public void make() {
        this.makeName();
        this.makeMusic();
        this.makeImage();
        this.makeEngine();
    }
}
```
```java
public class MakeWorld extends MakeGame{
    @Override
    public void makeName() {
        System.out.println("制作黑神话：悟空");
    }

    @Override
    public void makeMusic() {
        System.out.println("制作黑神话：悟空的音乐：云宫迅音");
    }

    @Override
    public void makeImage() {
        System.out.println("制作黑神话：悟空的画面：4K");
    }

    @Override
    public void makeEngine() {
        System.out.println("制作黑神话：悟空的引擎：虚幻5引擎");
    }
}
```
```java
public class MakeBus extends MakeCar{
    @Override
    public void makeHead() {
        System.out.println("bus：组装车头");
    }

    @Override
    public void makeBody() {
        System.out.println("bus：组装车身");
    }

    @Override
    public void makeTail() {
        System.out.println("bus：组装车尾");
    }
}
```
```java
public class MakeJeep extends MakeCar{
    @Override
    public void makeHead() {
        System.out.println("Jeep：组装车头！");
    }

    @Override
    public void makeBody() {
        System.out.println("Jeep：组装车身！");
    }

    @Override
    public void makeTail() {
        System.out.println("Jeep：组装车尾！");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        MakeCar bus = new MakeBus();
        bus.make();
        System.out.println("-------------------");
        MakeCar jeep = new MakeJeep();
        jeep.make();
        System.out.println("-------------------");
        MakeGame game = new MakeWorld();
        game.make();
    }
}
```

## 21、备忘录模式

### 什么是备忘录模式

Memento模式也叫备忘录模式，是行为i模式之一，它的作用是保存对象的内部状态，并在需要的时候（undo/rollback）恢复
对象以前的状态。<br>

### 备忘录模式的应用场景

如果一个对象需要保存状态并可通过undo或rollback等操作恢复到以前的状态时，可以使用Memento模式。<br>
1. 一个类需要保存它的对象的状态（相当于Originator角色）
2. 设计一个类，该类只是用来保存上述对象的状态（相当于Memento角色）
3. 需要的时候，Caretaker角色要求Originator返回一个Memento并加以保存
4. undo或rollback操作时，通过Caretaker保存的Memento恢复Originator对象的状态

### 备忘录模式的角色

+ Originator（原生者）：需要被保存状态以便恢复的那个对象。
+ Memento（备忘录）：该对象由Originator创建，主要用来保存Originator的内部状态。
+ Caretaker（管理者）：负责在适当的时间保存/恢复Originator对象的状态

实例<br>
```java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```
```java
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```
```java
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

## 22、状态模式

### 什么是状态模式

State模式也叫做状态模式，是行为设计模式的一种。State模式允许通过改变对象的内部状态而改变对象的行为，这个对象表现就好像
修改了它的类一样。

### 状态模式的应用场景

状态模式主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。把状态的判断逻辑转译到表现不同状态的一些列类
当中，可以把复杂的判断逻辑简化。

### 状态模式的角色

+ Context：用户对象拥有一个State类型的成员，以标识对象的当前状态；
+ State：接口或基类封装与Context的特定状态相关的行为；
+ ConcreteState：接口实现类或子类实现了一个与Context某个状态相关的行为。

实例<br>
```java
public class Person {
    private int hour;

    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }

    public void doSomething() {
        if (hour == 7) {
            System.out.println("吃早饭！");
        } else if (hour == 12) {
            System.out.println("吃午饭！");
        } else if (hour == 18) {
            System.out.println("吃晚饭！");
        } else {
            System.out.println(hour + "未定义。。。。。。");
        }
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        Person person = new Person();
        person.setHour(7);
        person.doSomething();
        person.setHour(12);
        person.doSomething();
        person.setHour(18);
        person.doSomething();
        person.setHour(14);
        person.doSomething();
    }
}
```

## 23、命令模式

### 什么是命令模式

Command模式也叫命令模式，是行为设计模式的一种。Command模式通过被称为Command的类封装了对目标对象的调用
行为以及调用参数。

### 命令模式的应用场景

在面向对象的程序设计中，一个对象调用另一个对象，一般情况下的调用过程是：<br>
1. 创建目标对象实例
2. 设置调用参数
3. 调用目标对象的方法

但在一些情况下有必要使用一个专门的类对这种调用加以封装，我们把这种专门的类称作command类。<br>
+ 整个调用过程比较繁杂，或者存在多处这种调用。这时，使用Command类对该调用加以封装，便于功能的再利用。
+ 调用前后需要对调用参数进行某些处理。
+ 调用前后需要进行某些额外处理，比如日志，缓存，记录历史操作等。

### 命令模式的角色

1. Command：Command抽象类
2. ConcreteCommand： Command的具体实现类
3. Receiver：需要被调用的目标对象
4. Invorker：通过Invorker执行Command对象

实例<br>
**接收者角色类**<br>
```java
public class Receiver { // 接收者角色类
    // 真正执行命令相应的操作
    public void action() {
        System.out.println("执行操作！");
    }
}
```
**抽象命令角色类**<br>
```java
public interface Command { //抽象命令角色类
    // 执行方法
    void execute();
}
```
**具体命令角色类**<br>
```java
public class ConcreteCommand implements Command{ // 具体命令角色类
    // 持有相应的接收者对象
    private Receiver receiver = null;

    /**
     * 构造方法
     * @param receiver
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        //通常会转调接收者的形影方法，让接收者来真正执行功能
        receiver.action();
    }
}
```
**请求者角色类**<br>
```java
public class Invoker { // 请求者角色类
    // 持有命令对象
    private Command command = null;

    /**
     * 构造方法
     * @param command
     */
    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 行动方法
     */
    public void action() {
        command.execute();
    }
}
```
**客户端角色类**<br>
```java
public class Client { // 客户端角色类
    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令对象，设定其接收者
        Command command = new ConcreteCommand(receiver);
        // 创建请求者，把命令对象设置进去
        Invoker invoker = new Invoker(command);
        // 执行方法
        invoker.action();
    }
}
```

## 24、访问者模式

### 什么是访问者模式

Visitor模式也叫访问者模式，是行为模式之一，它分离对象的数据和行为，使用Visitor模式，可以不修改已有类的情况下，增加
新的操作。最复杂的设计模式，并且使用频率不高。很多人对访问者模式的评价：
**大多情况下，你不需要使用访问者模式，但是 一旦需要使用它时，那就真的需要使用了。**

### 访问者模式的角色

1. 访问者角色（Visitor）：为该对象结构中具体元素角色声明一个访问操作接口。该操作接口的名字和参数标识了发送访问请求给具体访问者的具体元素角色。这样访问者就可以通过该元素角色的特定接口直接访问它。
2. 具体访问者角色（Concrete Visitor）：实现每个由访问者角色（Visitor）声明的操作。
3. 元素角色（Element）：定义一个Accept操作，它已一个访问者为参数。
4. 具体元素角色（Concrete Element）：实现由元素角色提供的Accept操作。
5. 对象结构角色（Object Structure）：这是使用访问者模式必备的角色。它要具备以下特征：能枚举它的元素；可以提供一个高层的接口以允许该访问者访问它的元素；可以是一个复合（组合模式）或是一个集合，如一个列表或一个无序集合。

实例<br>
```java
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
```
```java
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
```
```java
public class Monitor implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
```
```java
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
```
```java
public class Computer implements ComputerPart{
    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
```
```java
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
```
```java
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying monitor");
    }
}
```
```java
public class MainClass {
    public static void main(String[] args) {
        ComputerPart computerPart = new Computer();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}
```

