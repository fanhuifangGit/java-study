package com.fanhf.javastudy.methodSpace;


/**
 * @author fanhf
 * @Description
 *
 * staticObj、insObj、methodObj存放在哪里？
 *
 * @date 2020-12-15 10:11
 */
public class StaticObjTest {
    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder insObj = new ObjectHolder();
        void foo(){
            ObjectHolder methodObj = new ObjectHolder();
            System.out.println("done");
        }
    }
    private static class ObjectHolder{
    }

    public static void main(String[] args) {
        Test test = new StaticObjTest.Test();
        test.foo();
    }
}   
