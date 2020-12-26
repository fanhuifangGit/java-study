package com.fanhf.javastudy.heaptest;

import java.util.ArrayList;
import java.util.Random;

/**
 *  @Description:
 * -Xms600m -Xmx600m
 *
 *  @author: fanhf
 *  @Date: 2020/12/23 15:56
 */

public class HeapInstanceTest {
    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];
    public static void main(String[] args) {
        ArrayList<HeapInstanceTest>  list = new ArrayList<>();
        System.out.println("start......");
        int i = 0;
        while (true){
            list.add(new HeapInstanceTest());

            try {
                Thread.sleep(1000);
               System.out.println(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
