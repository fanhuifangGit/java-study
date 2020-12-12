package com.fanhf.javastudy.heaptest;

import java.util.ArrayList;

/**
 * @author fanhf
 * @Description 测试Major GC 、Minor GC 、Full GC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 * @date 2020-12-08 16:47
 */
public class GCTest {
    public static void main(String[] args){
        int i = 0;
        try {
            ArrayList<String> list = new ArrayList<>();
            String a= "com.fanhf";
            while (true){
                list.add(a);
                a+=a;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("遍历次数:"+i);
        }
    }
}   
