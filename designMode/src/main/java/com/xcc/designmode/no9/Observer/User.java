package com.xcc.designmode.no9.Observer;

import java.util.Observable;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class User extends Observable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.setChanged();
        this.notifyObservers("username被修改了====" + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.setChanged();
        this.notifyObservers("password被修改了====" + password);
    }
}
