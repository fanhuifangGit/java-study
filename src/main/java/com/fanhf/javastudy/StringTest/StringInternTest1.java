package com.fanhf.javastudy.StringTest;

public class StringInternTest1 {
    public static void main(String[] args) {
        //执行完下面一行的代码后，字符串常量池中不存在“11”，
        String s2 = new String("a") + new String("b");
        //在字符串常量池中生成对象“11”
        String s3 = "ab";

        /**
         * jdk6中：在串池中创建一个字符串“ab”
         * jdk8中：串池中没有创建“ab”，而是创建一个引用，指向 new String("11")，将此引用返回；
         */

        String s4 = s2.intern();
        String s5 = "ab";
        //jdk6：true  jdk8：false
        System.out.println(s2 == s3);
        System.out.println(s2 == s5);
        //jdk6：false jdk8：true
        System.out.println(s4 == s3);
        System.out.println(s4 == s5);
    }
}
