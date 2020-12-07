package com.fanhf.javastudy.heaptest;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author fanhf
 * @Description OOM复现
 * @date 2020-11-30 18:49
 */
public class OOMTest {

    public  static  void main(String[] args){
        ArrayList<Picture> list =  new ArrayList<>();
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Picture(new Random().nextInt(1024*1024)));
        }
    }
}

class Picture{
    private  byte[] pixels;

    public Picture(int length) {
        this.pixels = new byte[length];
    }
}
