package com.xcc.designmode.no24.Visitor;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
