package com.fanhf.javastudy.codeCommand;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-14 18:17
 */
public class CodeStudy {
    public void test1(){
        byte  i =           15;
        int j = 8;
        int k = i+j;
    }

    public static int test2(){
        int i = 10;
        int j = 20;
        int k = i+j;
        return k;
    }

    public void test3(){
        //如果被调用的方法带有返回值的话，其返回值将会被压入当前栈帧的操作数栈中，并更新pc寄存器中下一条需要执行的字节码指令
        int j = test2();
        int s = 80000;
    }
}   
