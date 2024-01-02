package com.xcc.designmode.no15.Adapter;

import java.util.Objects;

/**
 * @Author GamePlayer-Joker
 * @Date 2024/1/2
 */
public class LogAdapter implements LogFactory{
    private NbLogger nbLogger;

    public LogAdapter(NbLogger nbLogger) {
        this.nbLogger = nbLogger;
    }

    @Override
    public void debug(String tag, String message) {
        Objects.requireNonNull(nbLogger);
        nbLogger.d(1, message);
    }
}
