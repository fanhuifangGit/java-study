package com.fanhf.javastudy.classloader;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-19 16:13
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        try {
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            ClassLoader classLoader2 =  ClassLoader.getSystemClassLoader();
            System.out.println(classLoader2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}   
