package com.xcc.designmode.no21.Memento;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
