package com.fanhf.javastudy.classloader;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {

    public  static void main(String[] args){
        System.out.println("*************启动类加载器****************");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println("第 " + i + " 个:" + urLs[i]);
            /**
             * 第 0 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/resources.jar
             * 第 1 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/rt.jar
             * 第 2 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/sunrsasign.jar
             * 第 3 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/jsse.jar
             * 第 4 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/jce.jar
             * 第 5 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/charsets.jar
             * 第 6 个:file:/C:/Program%20Files/Java/jdk1.8.0_101/jre/lib/jfr.jar
             **/
        }

        //从上面打出来的jar包中，选择一个jar包，解压后，找到其中的一个类，以/C:/Program Files/Java/jdk1.8.0_101/jre/lib/jsse.jar中Provider的为例
        ClassLoader classLoader = Provider.class.getClassLoader();
        //null，凡是获取的加载器为null，说明是引导类加载器
        System.out.println(classLoader);

        System.out.println("*************扩展类加载器******************");
        String property = System.getProperty("java.ext.dirs");
        for (String path:property.split(";")) {
            System.out.println("path:"+path);
            /**
             * path:C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext
             * path:C:\Windows\Sun\Java\lib\ext
             **/
        }
        //从上面打出来的jar包中，选择一个jar包，解压后，找到其中的一个类，以C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunec.jar中的CurveDB为例
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        //ExtClassLoader
        System.out.println("classLoader1:" + classLoader1);
    }
}   
