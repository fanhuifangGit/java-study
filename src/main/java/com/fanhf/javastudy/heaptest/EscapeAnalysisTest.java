package com.fanhf.javastudy.heaptest;

/**
 * 逃逸分析
 * 如何快速的判断是否发生了逃逸分析，就看new的对象实体是或否有可能在方法外被调用
 * 放在堆的是对象实体
 * 没有发生逃逸，就会使用栈上分配
 */
public class EscapeAnalysisTest {


    public EscapeAnalysisTest obj;

    /**
     * 方法返回EscapeAnalysisTest对象，发生逃逸
     */
    public EscapeAnalysisTest getInstance(){
        return obj == null ? new EscapeAnalysisTest() : obj;
    }

    /**
     * 为成员属性赋值，发生逃逸
     */
    public void setObj(){
        this.obj = new EscapeAnalysisTest();
    }


    /**
     * 思考：如果当前的obj引用声明为static的，是否还会发生逃逸？慧发生
     */

    /**
     * 对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void useEscapeAnalysisTest(){
        EscapeAnalysisTest eat = new EscapeAnalysisTest();
    }


    /**
     * 引用成员变量的值，发生逃逸
     */
    public  void useEscapeAnalysisTest1(){
        EscapeAnalysisTest  es = getInstance();

        //getInstance().xxx()同样慧发生逃逸
    }

}
