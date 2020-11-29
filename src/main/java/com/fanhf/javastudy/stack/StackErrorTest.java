package com.fanhf.javastudy.stack;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-22 18:37
 *
 * 不设置栈大小，count=11405
 * 设置栈大小，-Xss256k,count=2466  说明设置起作用了
 */
public class StackErrorTest {

    public static int count = 1;
    public static void main(String[] args){

        System.out.println(count);
          
        count++;
//      java.lang.StackOverflowError
        main(args);
    }

    public  void test(){
         int i=10;
         byte q =127;



    }
}   
