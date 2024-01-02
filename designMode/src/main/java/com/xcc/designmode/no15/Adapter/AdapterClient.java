package com.xcc.designmode.no15.Adapter;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class AdapterClient {
    public void recordLog() {
        LogFactory logFactory = new LogAdapter(new NbLoggerImp());
        logFactory.debug("测试", "logger打印log");
    }
}
