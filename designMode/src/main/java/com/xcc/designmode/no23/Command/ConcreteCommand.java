package com.xcc.designmode.no23.Command;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/4
 */
public class ConcreteCommand implements Command{ // 具体命令角色类
    // 持有相应的接收者对象
    private Receiver receiver = null;

    /**
     * 构造方法
     * @param receiver
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        //通常会转调接收者的形影方法，让接收者来真正执行功能
        receiver.action();
    }
}
