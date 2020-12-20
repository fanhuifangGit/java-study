package com.fanhf.javastudy.StringTest;


/**
 *  String的垃圾回收：
 *  -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 */
public class StringGCTest {

    /**
     * 测试案例：
     * 1、先把参数配置上，注释掉for循环，运行看结果
     * 2、把for循环打开，运行看结果
     * 3、把for循环次数改成1000，运行看结果
     * 4、把for循环次数改成10000，运行看结果
     * 5、把for循环次数改成100000，运行看结果
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            String.valueOf(i).intern();
        }
    }
}
