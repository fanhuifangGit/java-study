package com.fanhf.javastudy.sqlannotation;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-02 15:25
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

//  public static void read() {
//    local.set(DataSourceType.slave.getType());
//  }
//
//  public static void write() {
//    local.set(DataSourceType.master.getType());
//  }

    public static void setDataSource(String value) {
        local.set(value);
    }

    public static String getDataSource() {
        return local.get();
    }

    public static void clear() {
        local.remove();
    }
}