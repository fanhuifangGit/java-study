package com.fanhf.javastudy.methodSpace;


/**
 * @author fanhf
 * @Description non-final的类变量
 * @date 2020-12-14 15:11
 */
public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        order.hello();
        System.out.println(Order.count);
    }
}   
class Order{
    public static int count = 1;

    public static void hello(){
        System.out.println("hello");
    }
}