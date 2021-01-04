package com.fanhf.javastudy.StringTest;

public class StringInternTest {

    public static void main(String[] args) {
        //下面的一行代码创建了2个对象，一个在堆中new String("1")，一个在字符串常量池中
        String s = new String("1");
        //调用此方法前，字符串常量池中已经存在了“1”
        s.intern();
        String s1 = "1";
        //jdk6:false jdk7/8:false
        System.out.println(s == s1);


        //s2变量记录的地址的为：new String("11");
        //执行完下面的代码后，字符串常量池中不存在“11”，
        String s2 = new String("1") + new String("1");

        /**
         * 如何理解：
         * 执行下面intern()后，可以在字符串常量池中生成“11”；
         * jdk6：创建了一个新的对象“11”，也就有了新的地址
         * jdk7：此时，常量池中并没有创建“11”，而是创建了一个指向堆空间中的地址，为了节省堆的空间
         */
        s2.intern();
        //s3变量记录的地址：使用的上面的intern()代码执行时，在常量池中生成的“11”的地址。
        String s3 = "11";
        //jdk6:false jdk7/8:true
        System.out.println(s2 == s3);

    }
}
