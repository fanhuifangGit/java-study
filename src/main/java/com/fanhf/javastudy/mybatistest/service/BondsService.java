package com.fanhf.javastudy.mybatistest.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanhf.javastudy.mybatistest.bean.BondsBean;
import com.fanhf.javastudy.mybatistest.dao.BondsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-20 13:57
 */
@Service
@Slf4j
public class BondsService {
    private static final  String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    @Autowired
    private BondsDao bondsDao;

    //RedisTemplate一定要加上泛型，而且泛型是String，Object也会乱码
    @Autowired
    private  RedisTemplate<String , String> redisTemplate;

    public List<BondsBean> getBondsList() {
        return bondsDao.getBondsList();
    }

    public BondsBean getBondsListById(BondsBean bondsBean) {
/**
 * redisTemplate.opsForValue();//操作字符串
 *
 * redisTemplate.opsForHash();//操作hash
 *
 * redisTemplate.opsForList();//操作list
 *
 * redisTemplate.opsForSet();//操作set
 *
 * redisTemplate.opsForZSet();//操作有序set
 *
 **/


        BondsBean bondsBean1 = bondsDao.getBondsListById(bondsBean);
//        String redisKey = String.format("%s:%s","bondId","bondName");
//        String value = (String) redisTemplate.opsForValue().get(redisKey);
//        List<BondsBean> list = JSON.parseArray(value,BondsBean.class);
//        if(null==list){
//             list =  new ArrayList<>();
//        }
//        list.add(bondsBean1);
//        String redisValue = JSONObject.toJSONString(list);
//        redisTemplate.opsForValue().set(redisKey,redisValue);
//        redisTemplate.delete(redisKey);
        log.info("==================list操作============================");
//        List<String> list1 =  new ArrayList();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        redisTemplate.opsForList().leftPush("listkey1", JSONObject.toJSONString(list1));
//        redisTemplate.opsForList().rightPush("listkey2","33333333");
//        redisTemplate.opsForList().rightPopAndLeftPush("listkey2","3333333333");
//        String[] strings =  new String[]{"asd","fgh","jkl"};
//        redisTemplate.opsForList().rightPushAll("listkey2",strings);
//        log.info("======================="+ redisTemplate.opsForList().range("listkey2",0,-1));
//        log.info("======================="+ redisTemplate.opsForList().leftPop("listkey2"));


        log.info("====================hash操作==========================");
//        redisTemplate.opsForHash().put("h1","h2","v1");
//        redisTemplate.opsForHash().put("redishash","name","tom");
//        Map<String, String> map =  new HashMap<>();
//        map.put("hash1","value1");
//        map.put("hash2","value2");
//        redisTemplate.opsForHash().putAll("hashMap",map);
//        log.info("====================="+redisTemplate.opsForHash().get("redishash","name"));
//        log.info("====================="+redisTemplate.opsForHash().get("hashMap","hash1"));
//        log.info("========keys============="+redisTemplate.opsForHash().keys("hashMap"));
//        log.info("========size============="+redisTemplate.opsForHash().size("hashMap"));
//        log.info("========entries============="+redisTemplate.opsForHash().entries("hashMap"));


        log.info("====================set操作==========================");
//        String[] strings =  new  String[]{"aaaa","bbbb","cccc","dddd"};
//        redisTemplate.opsForSet().add("setKey",strings);
//        redisTemplate.opsForSet().add("setKey1","eeee");
//        redisTemplate.opsForSet().add("setKey2","ffff");
//        redisTemplate.opsForSet().add("setKey3","hhhh");
//        redisTemplate.opsForSet().add("setKey3","iiii");
//        redisTemplate.opsForSet().add("setKey3","cccc");
//        ;
//        log.info("=========difference=========="+ redisTemplate.opsForSet().difference("setKey2","setKey1"));
//        log.info("=========union=========="+ redisTemplate.opsForSet().union("setKey2","setKey1"));
//        log.info("=========unionAndStore=========="+ redisTemplate.opsForSet().unionAndStore("setKey2","setKey1","setKey1-setKey2-union"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().members("setKey"));
//        log.info("=========isMember=========="+ redisTemplate.opsForSet().isMember("setKey","bbbb"));
//        log.info("=========opsForSet=========="+ redisTemplate.opsForSet().size("setKey"));
//        log.info("=========pop=========="+ redisTemplate.opsForSet().pop("setKey1"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().members("setKey2"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().members("setKey3"));
//        log.info("=========remove=========="+ redisTemplate.opsForSet().remove("setKey3","hhhhhhh"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().members("setKey3"));
//        log.info("=========randomMember=========="+ redisTemplate.opsForSet().randomMember("setKey"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().members("setKey"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().intersectAndStore("setKey","setKey3","setKey-setKey3-intersect"));
//        log.info("=========members=========="+ redisTemplate.opsForSet().members("setKey-setKey3-intersect"));


        log.info("====================zset操作==========================");
        ZSetOperations.TypedTuple<String> objectTypedTuple1 = new DefaultTypedTuple<String>("zset-1",9.1);
        ZSetOperations.TypedTuple<String> objectTypedTuple2 = new DefaultTypedTuple<String>("zset-2",9.2);
        ZSetOperations.TypedTuple<String> objectTypedTuple3 = new DefaultTypedTuple<String>("zset-3",9.3);
        ZSetOperations.TypedTuple<String> objectTypedTuple4 = new DefaultTypedTuple<String>("zset-4",9.4);
        ZSetOperations.TypedTuple<String> objectTypedTuple5 = new DefaultTypedTuple<String>("zset-5",9.5);
        ZSetOperations.TypedTuple<String> objectTypedTuple6 = new DefaultTypedTuple<String>("zset-6",9.6);
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<ZSetOperations.TypedTuple<String>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        tuples.add(objectTypedTuple4);
        tuples.add(objectTypedTuple5);
        tuples.add(objectTypedTuple6);

        ZSetOperations.TypedTuple<String> tuples1 = new DefaultTypedTuple<String>("zset2-1",8.1);
        ZSetOperations.TypedTuple<String> tuples2 = new DefaultTypedTuple<String>("zset2-2",8.2);
        ZSetOperations.TypedTuple<String> tuples3 = new DefaultTypedTuple<String>("zset2-3",8.3);
        Set<ZSetOperations.TypedTuple<String>> stuples1 = new HashSet<ZSetOperations.TypedTuple<String>>();
        stuples1.add(objectTypedTuple1);
        stuples1.add(objectTypedTuple2);
        stuples1.add(objectTypedTuple3);

        log.info("======add=zset1==============="+redisTemplate.opsForZSet().add("zset1",tuples));
        log.info("======add=zset2============"+redisTemplate.opsForZSet().add("zset2",stuples1));
        log.info("======range================"+redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======zCard================"+redisTemplate.opsForZSet().zCard("zset1"));
        log.info("======incrementScore================"+redisTemplate.opsForZSet().incrementScore("zset1","zset-1",1.1));
        log.info("======intersectAndStore================"+redisTemplate.opsForZSet().intersectAndStore("zset1","zset2", "zset1-zset2-intersect"));
        log.info("======range================"+redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======rangeByScore================"+redisTemplate.opsForZSet().rangeByScore("zset1",0,5));
        log.info("======reverseRange================"+redisTemplate.opsForZSet().reverseRange("zset1",0,-1));
        log.info("======reverseRangeByScore================"+redisTemplate.opsForZSet().reverseRangeByScore("zset1",0,-1));
        log.info("======count================"+redisTemplate.opsForZSet().count("zset1",0,-1));
        log.info("======rank================"+redisTemplate.opsForZSet().rank("zset1","zset-1"));
        log.info("======size================"+redisTemplate.opsForZSet().size("zset1"));


        return bondsBean1;
    }
}
