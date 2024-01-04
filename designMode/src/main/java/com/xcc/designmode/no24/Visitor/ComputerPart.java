package com.xcc.designmode.no24.Visitor;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
