package com.xcc.designmode.no16.Interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
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
