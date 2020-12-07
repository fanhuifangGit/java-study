package com.fanhf.javastudy.interceptor;

import com.fanhf.javastudy.sqlannotation.ChooseDataSource;
import com.fanhf.javastudy.sqlannotation.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-02 15:22
 */
@Aspect
@Component
@Order(1)
public class    DataSourceAspect {

    private Logger log = LoggerFactory.getLogger(DataSourceAspect.class);


    @Pointcut(value = "@within(org.springframework.stereotype.Service) && @annotation(dataSource)")
    public void multiDataSourcePointCut(ChooseDataSource dataSource) {
        // APSECT POINT CUT FUNCTION
    }

    @Before(value = "multiDataSourcePointCut(dataSource)")
    public void beforeSwitchDS(JoinPoint point, ChooseDataSource dataSource) {
        log.info("change DATABASE to {}", dataSource.value());
        DataSourceContextHolder.setDataSource(dataSource.value());
    }

    @After(value = "multiDataSourcePointCut(dataSource)")
    public void afterSwitchDS(ChooseDataSource dataSource) {
        log.info("Clear datasource");
        DataSourceContextHolder.clear();
    }
}   
