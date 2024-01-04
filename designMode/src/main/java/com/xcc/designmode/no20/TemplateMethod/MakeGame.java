package com.xcc.designmode.no20.TemplateMethod;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
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
