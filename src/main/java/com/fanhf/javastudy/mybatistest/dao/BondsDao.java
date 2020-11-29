package com.fanhf.javastudy.mybatistest.dao;

import com.fanhf.javastudy.mybatistest.bean.BondsBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-20 13:57
 */
@Mapper
@Component(value = "bondsMapper")
public interface BondsDao {
    public List<BondsBean> getBondsList();

    BondsBean getBondsListById(BondsBean bondsBean);
}
