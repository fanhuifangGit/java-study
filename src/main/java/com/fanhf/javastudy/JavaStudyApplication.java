package com.fanhf.javastudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication

//
/**
 * https://mp.weixin.qq.com/s?__biz=MzI4NTM1NDgwNw==&mid=2247486981&idx=2&sn=338f0f443bb50ee4a9be7de5d35e7e73&chksm=ebec305ddc9bb94b424bdd0f6f2ca440fdd97e379113140fb9239910cf2603fcce9aa216756c&mpshare=1&scene=1&srcid=1207olQbtwbIVcbwaiSSyNai&sharer_sharetime=1607318984334&sharer_shareid=612f5b49e3a144665772976c7ebceb16&key=caee7f8dc320c5c15796fbf0338920586e8a7063074b7e70273cffac7798334a26bab1f9ea7e37c00b32a873a15a9085b2d01d26c7b721d38ab3ae65fac97cc21dc14cd27bb676ca0774799b08ff9e8324669895de2a772c62f5773d90058cc9babdd173d7732cdbc2dd24cff830b787aec1c44f8aabad6d08536f2d6493d7b3&ascene=1&uin=MjYxMTc2MDAwMw%3D%3D&devicetype=Windows+10+x64&version=63000039&lang=zh_CN&exportkey=Afz7bkNmM9i3hDiuvmG%2B1gw%3D&pass_ticket=OEX%2BubR0kIR1ZL23nzw2gyVY%2BB4ZrW96h3qNRAefzaQR1iWpsoEnRyggWs9pT1gP&wx_header=0
 * "@SpringBootApplication"等同于如下3个注解
 * "@Configuration"
 * "@EnableAutoConfiguration"
 * "@ComponentScan"
 **/

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Slf4j
public class JavaStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaStudyApplication.class, args);
        log.info("启动成功...........");
    }

}
