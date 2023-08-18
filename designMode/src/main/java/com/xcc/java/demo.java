package com.xcc.java;

import cn.hutool.core.convert.Convert;
import cn.hutool.db.handler.StringHandler;

import java.util.List;

/**
 * @Author xcc
 * @Date 2023/8/16
 */
public class demo {

    public static void main(String[] args) {
        int a = 1;
        String aStr = Convert.toStr(a);

        Object[] b = {"a", "你好", "", 26, "!"};
        List<?> list = Convert.toList(b);
        System.out.println(list);

        String f1 = Convert.numberToChinese(12653, true);
        System.out.println(f1);

        String f2 = Convert.numberToChinese(12653, true);
        System.out.println(f2);


    }


}
