package com.fanhf.javastudy.stringFormat;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-27 16:14
 */
public class StringTest {
    public static void main(String[] args){
        test1();
        test2();
    }
    public static void test1(){
        String str1 = "111";
        String str  = "111";
        String str2 = "" + str;
        System.out.println(str1 == str2);
    }

    public static void test2(){
        String str1 = "111";
        String str  = "111";
        String str2 = "" + "111";
        System.out.println(str1 == str2);
    }
}   
