package com.fanhf.javastudy;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-10 16:20
 */
@Slf4j
public class JunitAnnotationTest {
    @BeforeClass
    //@BeforeClass  在所执行的带@test方法之前执行
    public  static void test(){
        int homeAir  = 1387;
        int homeTaix = 100;
        int toBJAir = 30;

        int backAir = 1138;
        int backTrain = 153;
        int backBachuTaix = 60;
        int backtoUrimuqiAir = 30;
        int tianjinbacktoBjTrain = 55;
        int home = homeAir+homeTaix+toBJAir;
        int back =backAir+backTrain+backBachuTaix+backtoUrimuqiAir+tianjinbacktoBjTrain;
        System.out.println("home:"+home);
        System.out.println("back:"+back);
        System.out.println("total:"+(home+back));
    }
    @Ignore("ignore")
    @Test
    public void testRedisKeysCommand(){
        log.info("========expire=============={}","11111");
        Assert.assertTrue(1==1);
    }

    @Ignore("ignore")
    @Test
    public void testRedis(){
        log.info("========last test=============={}","22222");
    }

    @Before
    public  void testBefore(){
        log.info("======== Before=============={}","66666");
    }


    @Test(timeout = 2000)
    // @Test 主类  timeout<1000，就会报错，>1000不会报错
    public void testRediss(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("======== @Test 主类=============={}","44444");

    }

    @After
    // @After 在每个测试方法执行后执行
    public  void test2(){
        log.info("========After=============={}","33333");
    }
    @AfterClass
    //@AfterClass 在最后一个测试方法执行后执行
    public static void test1(){
        log.info("========AfterClass=============={}","55555");
    }
}   
