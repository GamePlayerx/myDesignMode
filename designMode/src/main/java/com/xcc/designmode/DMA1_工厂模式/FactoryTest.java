package com.xcc.designmode.DMA1_工厂模式;

/**
 * 工程模式的测试
 * 对比发现，静态工厂模式最佳，省了工厂实例的创建
 */
public class FactoryTest {
    public static void main(String[] args) {
        // 1、使用单方法工厂模式进行测试
        FoodFactory1 factory1 = new FoodFactory1();
        String demo = "红烧肉";
        Food food1 = factory1.creatFood("红烧肉");
        food1.foods(demo);
        Food food11 = factory1.creatFood("水果");
        food11.foods(demo);
        Food food111 = factory1.creatFood("巧克力");
        if (food111 == null) {
            System.out.println("创建失败！");
        } else {
            System.out.println("来点巧克力");
        }
        System.out.println("=========================");

        // 2、使用多方法工厂模式进行测试
        FoodFactory2 factory2 = new FoodFactory2();
        Food food2 = factory2.createFruits();
        food2.foods(demo);
        Food food22 = factory2.createMeat();
        food22.foods(demo);
        System.out.println("=========================");

        // 3、使用静态工厂模式进行测试
        Food food3 = FoodFactory3.createFruits();
        food3.foods(demo);
        Food food33 = FoodFactory3.creatMeat();
        food33.foods(demo);

    }

}
