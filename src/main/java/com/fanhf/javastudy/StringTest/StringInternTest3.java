package com.fanhf.javastudy.StringTest;


/**
 * 使用intern()测试执行效率:空间使用上
 *
 * 结论：对于程序中大量存储的字符串，尤其其中存在很多重复
 * 字符串时，使用intern()可以节省内存空间。
 */
public class StringInternTest3 {
    static final int MAX_COUNT = 1000 * 10000;
    static final String[] arr = new String[MAX_COUNT];

    public static void main(String[] args) {
       Integer[] data = new Integer[]{1,2,3,4,5,6,7,8,9,10};
       long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_COUNT; i++) {
            //5175ms
//            arr[i] = new String(String.valueOf(data[i%data.length]));
            //1180ms
            arr[i] = new String(String.valueOf(data[i%data.length])).intern();
        }
       long end = System.currentTimeMillis();
        System.out.println("spend time:" + (end-start) + "ms");

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
    }
}
