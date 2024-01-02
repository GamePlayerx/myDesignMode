package com.xcc.designmode.no16.Interpreter;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
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
