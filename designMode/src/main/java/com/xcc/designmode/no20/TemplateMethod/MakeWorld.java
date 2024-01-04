package com.xcc.designmode.no20.TemplateMethod;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
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
