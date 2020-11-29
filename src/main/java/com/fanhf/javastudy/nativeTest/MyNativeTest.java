package com.fanhf.javastudy.nativeTest;

/**
 * @author fanhf
 * @date 2020-11-26 12:11
 */
public class MyNativeTest {
    public  native  void native1(int x);
    public  native static long native2(long y);
    private  native synchronized  boolean native3(boolean z);
//    private native abstract int (Object obj);//native和abstract不能共用
    public  native String[] native4(String[] arr);
}   
