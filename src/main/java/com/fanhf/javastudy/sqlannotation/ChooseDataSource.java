package com.fanhf.javastudy.sqlannotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ChooseDataSource {

    String value() default "master";
}
