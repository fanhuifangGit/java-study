package com.fanhf.javastudy.internal_storage;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-17 16:05
 */
public class MovieCopyByIOAndNIOTest {
    private  static final  int _100MB = 1024 * 1024 * 100;
    private  static final String RESOURCE = "";
    public static void main(String[] args) {
        long sum = 0;
        String src = "";
        for (int i = 0; i < 3 ; i++) {
            String dest = "" + i +".mp4";
            sum += io(src, dest);
//            sum += directBuffer(src, dest);
        }
        System.out.println("总花费时间为:"+sum);
    }

 /**
  * io方式读取文件
  **/
 private static  long io(String src,String dest){
      long start =  System.currentTimeMillis();
      FileInputStream fis = null;
      FileOutputStream fos = null;
      File file;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            byte[] buffer = new byte[_100MB];
            while (true){
                try {
                    int len = fis.read(buffer);
                    if(-1 == len){
                        break;
                    }
                    fos.write(buffer,0,len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long end =  System.currentTimeMillis();
        return end - start;
    }

    /**
     * nio方式读取文件
     **/
    private static  long directBuffer(String src,String dest){
        long start =  System.currentTimeMillis();

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        File file;
        try {
            inChannel = new FileInputStream(src).getChannel();
            outChannel = new FileOutputStream(dest).getChannel();

            ByteBuffer bf = ByteBuffer.allocateDirect(_100MB);
            while( inChannel.read(bf) != -1){
                bf.flip();//修改为读数据模式
                outChannel.write(bf);
                bf.clear();//清空
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end =  System.currentTimeMillis();
        return end - start;
    }
}   
