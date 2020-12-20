package com.fanhf.javastudy.methodSpace;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author fanhf
 * @Description
 *
 * jdk8中：
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * jdk6中：
 * -XX:PermSize=10m -XX:MaxPermSize=10m
 *
 * @date 2020-12-14 14:00
 */
public class OOMTest extends ClassLoader{
    public static void main(String[] args){
    int  j = 0;
        try {
            OOMTest oomTest = new OOMTest();
            for (int i = 0; i < 10000; i++) {
                //创建ClassWriter，用来生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，public，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                //返回byte
                byte[] bytes = classWriter.toByteArray();
                //类的加载，class对象
                oomTest.defineClass("Class"+i,bytes,0,bytes.length);
                j++;
            }
        } finally {
            System.out.println("j:"+j);
        }
    }
}   
