package com.fanhf.javastudy.internal_storage;


import io.netty.channel.Channel;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author fanhf
 * @Description -Xmx20m -XX:MaxDirectMemorySize=10m
 *              Exception in thread "main" java.lang.OutOfMemoryError
 * @date 2020-12-17 15:45
 */
public class MaxDirectMemorySizeTest {
    private  static final  long _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe  unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}   
