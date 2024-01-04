package com.xcc.designmode.no21.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
