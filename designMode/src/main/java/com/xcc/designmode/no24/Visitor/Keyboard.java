package com.xcc.designmode.no24.Visitor;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
