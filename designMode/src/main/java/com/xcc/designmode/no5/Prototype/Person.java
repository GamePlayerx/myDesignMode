package com.xcc.designmode.no5.Prototype;
import java.util.List;
import java.util.ArrayList;

/**
 * Cloneable:相当于一个标记 加了之后可以做克隆的事
 *
 * @Author GamePlayer-Joker
 * @Date 2023/12/28
 */
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
