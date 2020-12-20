package com.fanhf.javastudy.StringTest;


public class StringNewTest {
    public static void main(String[] args) {
        /**
         * new String("ab")会创建几个对象？看字节码，可以得知是2个
         * 一个对象是：new 关键字在堆中创建的
         * another is：字符串常量池中的对象“ab”，字节码指令：ldc
         */
        String str1 = new String("ab");

        /**
         * new String("a") + new String("b")会创建几个对象？
         * 对象1：new StringBuilder()
         * 对象2：new String("a")
         * 对象3：字符串常量池中的“a”对象，字节码指令：ldc
         * 对象4：new String("b")
         * 对象5：字符串常量池中的“b”对象，字节码指令：ldc
         *
         * 深入剖析 ：StringBuilder.toString()
         *
         * 对象6：new String("ab")
         * 可以看到字节码中，在 “ invokevirtual #9 <java/lang/StringBuilder.toString>”指令中
         * 没有ldc的字节码指令，说明toString()的调用并没有在串池中生成“ab”
         *
         */
        String str2 = new String("a") + new String("b");
        System.out.println(str2);
    }
}
