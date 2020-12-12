package com.fanhf.javastudy.heaptest;

public class TLABTest {
    /**
     * 测试 -XX:UseTLAB 参数是否开启
     * @param args
     */
    public static void main(String[] args){
        System.out.println("start...............");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end..............");
    }
}
