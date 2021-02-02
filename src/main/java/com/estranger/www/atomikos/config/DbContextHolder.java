package com.estranger.www.atomikos.config;

/**
 * Author：Estranger
 * Description：
 * Date：2020/7/24
 */
public class DbContextHolder {

    private static ThreadLocal<String> threadLocal = new ThreadLocal();

    /**
     * 设置数据源
     */
    public static void setDbType(String value){
        threadLocal.set(value);
    }

    /**
     * 取得数据源
     */
    public static String getDbType(){
        return threadLocal.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDbType(){
        threadLocal.remove();
    }
}
