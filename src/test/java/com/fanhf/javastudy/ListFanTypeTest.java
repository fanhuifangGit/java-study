package com.fanhf.javastudy;

import com.fanhf.javastudy.mybatistest.bean.BondsBean;
import com.fanhf.javastudy.mybatistest.bean.CommonBean;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-27 13:35
 */
public class ListFanTypeTest {
@Test
    public void test1(){
        List<BondsBean> list = new ArrayList<>();
        BondsBean bondsBean1 =  new BondsBean();
        bondsBean1.setBondId(111);
        bondsBean1.setBondCode("123456");
        bondsBean1.setId(1111111);
        list.add(bondsBean1);

        BondsBean bondsBean2 =  new BondsBean();
        bondsBean2.setBondId(222);
        bondsBean2.setBondCode("234567");
        bondsBean2.setId(2222222);
        list.add(bondsBean2);
        test2(list);
    }

    public void test2(List<? extends CommonBean> list){
        List<BondsBean> list1 = (List<BondsBean>) list;
        System.out.println(list1.get(1).getId());
    }
    @Test
    public void test3(){
        String envStr = "";
        String env = "";
        if(!Objects.equals("prod", "env")){
            envStr = env + "-";
        }
    }
}   
