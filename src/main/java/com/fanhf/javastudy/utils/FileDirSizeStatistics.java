package com.fanhf.javastudy.utils;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 13:56
 */
public class FileDirSizeStatistics {
    public static void main(String[] args){
//       Long s =  new BigDecimal(198765).divide(new BigDecimal(1024), 2, RoundingMode.DOWN).longValue();
//        System.out.println("s:"+s);
        String path = "D:\\tools";        //要遍历的路径
        File file = new File(path);
        read(file);
    }
    public  static  void  read(File filePath) {
        String path = filePath.getPath();
        File file = new File(path);
        Long size = 0L;
        Long totalSize = 0L;
        File[] files = file.listFiles();
        for(File dirFile:files){
            if(dirFile.isDirectory()){
                read(dirFile);
            }else{
                size += dirFile.length();
            }
        }

        if(size > 1024){
            totalSize = size == 0 ? 0 : new BigDecimal(size).divide(new BigDecimal(1024), 2, RoundingMode.DOWN).longValue();
            if(totalSize > 1024){
                totalSize = totalSize == 0 ? 0 : new BigDecimal(totalSize).divide(new BigDecimal(1024), 2, RoundingMode.DOWN).longValue();
                System.out.println(filePath+" :"+totalSize +"M");
            }else{
                System.out.println(filePath+" :"+totalSize +"KB");
            }
        }
    }

}   
