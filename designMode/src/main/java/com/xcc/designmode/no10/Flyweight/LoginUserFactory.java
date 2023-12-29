package com.xcc.designmode.no10.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class LoginUserFactory {
    private static Map<String, LoginUser> pool = new HashMap<>();
    public LoginUserFactory() {
        pool = new HashMap<>();
    }
    public static LoginUser getLoginUser(String key) {
        LoginUser loginUser = pool.get(key);
        if (loginUser == null) {
            loginUser = new LoginUser("admin", "admin123");
            pool.put(key, loginUser);
        }
        return loginUser;
    }

    public static void setLoginUser(String key, LoginUser loginUser) {
        pool.put(key, loginUser);
    }
}
