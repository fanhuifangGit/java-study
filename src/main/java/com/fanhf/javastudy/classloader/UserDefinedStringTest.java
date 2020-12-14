package com.fanhf.javastudy.classloader;

public class UserDefinedStringTest {

    public static void main(String[] args){
        java.lang.String str = new java.lang.String();
        System.out.println("str:"+str);
        System.out.println("hello..............");
        /**
         * 打印结果：
         * str:
         * hello..............
         *
         * 说明：
         * java.lang.String() 是自定义的String，但并没有打印出静态代码块的内容，说明不是用的系统类加载器，
         * 而是用的父类的启动类加载器，启动类加载器可以加载，那么就会把结果返回，就没有系统类加载器的事情了。
         **/
        UserDefinedStringTest test = new UserDefinedStringTest();
        //AppClassLoader
        System.out.println(test.getClass().getClassLoader());
    }
}   
