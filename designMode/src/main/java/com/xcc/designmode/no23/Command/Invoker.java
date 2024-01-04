package com.xcc.designmode.no23.Command;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class Invoker { // 请求者角色类
    // 持有命令对象
    private Command command = null;

    /**
     * 构造方法
     * @param command
     */
    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 行动方法
     */
    public void action() {
        command.execute();
    }
}
