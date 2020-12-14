package com.fanhf.javastudy.heaptest;

/**
 * @author fanhf
 *              标量替换
 * @Description -server -Xmx100m -Xms100m -XX:+DoEscapeAnalysis  -XX:+PrintGC  -XX:+EliminateAllocations
 * @date 2020-12-10 18:56
 */
public class ScalaReplaceTest {

    public static class  User{
        public int id;
        public String name;
    }
    public static void alloc(){
        User user =  new User();
        user.id = 1;
        user.name = "fanhf";
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
    }
}   
