package com.fanhf.javastudy.heaptest;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-28 19:15
 */
public class HeapTest {
    //docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html

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
