package com.fanhf.javastudy.heaptest;

/**
 * @author fanhf
 * @Description 堆大小学习
 * @date 2020-11-30 13:36
 */
public class HeapSpecialInitial {
    /**
     *
     * 1、设置堆空间大小的参数
     * -Xms 用来设置堆空间（年轻代+老年代）的初始内存大小
     *      -X 是Jvm的运行参数
     *      ms 是memory start
     * -Xmx 用来设置堆空间（年轻代+老年代）的最大内存大小
     *
     * 2、默认堆空间大小
     *   初始化内存大小：物理电脑内存大小 / 64
     *                最大内存大小： 物理电脑内存大小 / 4
     *
     *3、手动设置 ： -Xms128 -Xmx128
     *          开发中建议将褚时堆内存和最大的堆内存设置成相同的值。
     *          因为： 频繁的扩容和释放，会对系统造成压力，如果初始值不够，就会不断地扩容，也会是得线程中断，影响系统运行。
     **/


    public  static  void main(String[] args){
        //java堆内存总量
        long initialMemeory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms:" + initialMemeory + "M");
        System.out.println("-Xms:" + initialMemeory + "M");
        System.out.println("系统内存大小为：" + maxMemory * 64.0 / 1024 + "G");
        System.out.println("系统内存大小为" + maxMemory * 4.0 / 1024 + "G");
    }
}   
