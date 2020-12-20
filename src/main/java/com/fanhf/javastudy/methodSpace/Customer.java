package com.fanhf.javastudy.methodSpace;

import java.time.temporal.ChronoUnit;

/**
 * @author fanhf
 * @Description
 *测试对象实例化的过程
 * 1、加载类元信息    2、为对象分配内存
 * 3、处理并发问题    4、属性的恶魔人初始化（零值初始化）
 * 5、设置对象头信息   6、属性的显式初始化，代码块中初始化，构造器初始化
 *
 *
 * 给对象的属性赋初始值的操作
 * 1、属性的默认初始化  2、显式初始化  3、代码块中的初始化 4、  构造器初始化
 *
 * @date 2020-12-15 16:33
 */
public class Customer {
    int id = 100;
    String name;
    Account acct;

    {
        name = "匿名客户";
    }
    public Customer(){
        acct = new Account();
    }
    class Account{
    }
}   
