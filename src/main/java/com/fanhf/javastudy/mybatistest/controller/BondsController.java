package com.fanhf.javastudy.mybatistest.controller;

import com.fanhf.javastudy.mybatistest.bean.BondsBean;
import com.fanhf.javastudy.mybatistest.service.BondsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-20 11:46
 */
@RestController
@RequestMapping("/bonds")
@Api(tags = "基金管理类")
@Slf4j
public class BondsController {
    @Autowired
    private BondsService bondsService;

    @PostMapping(value = "/bondslist")
    @ApiOperation(value = "列表展示")
    public List<BondsBean> getBondsList(){
       List<BondsBean>  bondsList = bondsService.getBondsList();
       log.info("{}",bondsList.toString());
       return bondsList;
    }

    @PostMapping(value = "/bondslistById")
    @ApiOperation(value = "列表展示")
    public BondsBean getBondsListById(@RequestBody BondsBean RequestBody){
        return bondsService.getBondsListById(RequestBody);
    }
}   
