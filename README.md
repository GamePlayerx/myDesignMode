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




