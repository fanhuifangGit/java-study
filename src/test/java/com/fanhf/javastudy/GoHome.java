package com.fanhf.javastudy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class GoHome {

    @Test
    public   void test(){
        int homeAir  = 1379;
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

}
