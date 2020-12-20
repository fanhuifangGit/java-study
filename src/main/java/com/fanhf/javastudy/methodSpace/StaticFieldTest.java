package com.fanhf.javastudy.methodSpace;

/**
 * @author fanhf
 * @Description
 * 结论：
 * 静态引用对应的对象实体始终都存在堆中
 *
 * jdk7
 * -Xms100m -Xmx100m -XX:PermSize=100m -XX:MaxPermSize=100m -XX:+PrintGCDetails
 *
 * jdk8
 * -Xms100m -Xmx100m -XX:MetaspaceSize=100m -XX:MaxMetaspaceSize=100m -XX:+PrintGCDetails
 *
 * @date 2020-12-15 09:56
 */
public class StaticFieldTest {
    //100M
    private static byte[] bytes =  new byte[1024*1024*10];

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.bytes);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}   
