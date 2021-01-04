package com.fanhf.javastudy.StringTest;

import org.junit.jupiter.api.Test;

public class StringInternTest2 {
    public static void main(String[] args) {

        //执行后，不会在串池中生成“ab”
        String s1 = new String("a") + new String("b");

        //执行后，串池中会生成“ab”
//        String s1 = new String("ab");

        String s2 = s1.intern();
//        String s2 = "ab";
        System.out.println(s1 == s2);
        System.out.println(s1 == s2);
    }
  @Test
    public  void test() {
        String x = "ab";
        String s = new String("a") + new String("b");
        String s2 = s.intern();
        //true
        System.out.println(s2 == x);
        //false
        System.out.println(s == x);
    }
}
