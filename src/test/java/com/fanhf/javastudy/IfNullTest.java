package com.fanhf.javastudy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fanhf
 * @Description null写前面和写后面
 * @date 2020-11-19 10:43
 */
public class IfNullTest {
    @Test
    public void test1(){
        String str1 = null;
        if(null == str1 ){
            System.out.println("11111111111");
        }
        if(str1 == null ){
            System.out.println("22222222222");
        }
        /**
         * ===================结论====================
         * 当仅仅对str1做null的判断，null写和写后都一样
         * 不会报错，输出会正常打印
         * 不过，将null写在左边时，null其实相当于一个常量
         * 避免把"==" 写成"="
         * ===================结论====================
         **/
    }

    @Test
    public void test2(){
        String str = null;
        // 情况1，执行报错：NullPointerException
        if(str.equals("1")){
            System.out.println("111111111111");
        }
        // 情况2 ,执行不会报错
        if("1".equals(str)){
            System.out.println("22222222222");
        }
        /**
         * ===================结论====================
         * 如果使用了“str.”去调用str的方法，比如length，substring，equals等：
         * 将已知的常量写在前面，可以避免空指针，程序会正常进行；
         * 反之，str写在前面，将已知的常量写在后面，会报空指针异常
         * ===================结论====================
         **/
    }
    @Test
    public void test3(){
        System.out.println(759+149*2+159+41.9+59+199);
        Integer index = 100;
//        System.out.println("100:"+String.valueOf(100).getClass());//(obj == null) ? "null" : obj.toString();
//        System.out.println("index:"+String.valueOf(index).getClass());//(obj == null) ? "null" : obj.toString();
//        System.out.println("index:"+index.toString().getClass());//Integer.toString(value);stringSize、getChars
//        System.out.println("index:"+Integer.toString(index)/*.getClass()*/);//Integer.toString(value);stringSize、getChars
        //选String。valueOf

    }
    @Test
    public  void test4(){
        Long ms = System.currentTimeMillis() / 1000L;
      System.out.println(ms.intValue());
    }

    @Test
    public  void test5(){
       List<String> list = null;
       if(list.size()==0){
           System.out.println("null");
       }
     }
     @Test
     public void test6(){
//        int i = 10/0;
//        System.out.println(i);
//         boolean fals = Boolean.parseBoolean("true");
//         System.out.println(fals);
//         if(fals){
//             System.out.println("1111111111111");
//         }
         HashMap map = new HashMap();
         map.put("security", "sss");
         map.put("channelNo", "aaaa");
        System.out.println(JSON.toJSONString(map));
     }
}   
