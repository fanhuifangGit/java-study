package com.fanhf.javastudy.heaptest;

/**
 * @author fanhf
 * @Description 测试大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * @date 2020-12-08 17:51
 */
public class YoungOldAreaTest {
    public static void  main(String[] args){
        //20m
        byte[] buf = new byte[1024*1024*20];
    }
}   
