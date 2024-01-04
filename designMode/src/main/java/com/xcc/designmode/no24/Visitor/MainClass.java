package com.xcc.designmode.no24.Visitor;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class MainClass {
    public static void main(String[] args) {
        ComputerPart computerPart = new Computer();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}
