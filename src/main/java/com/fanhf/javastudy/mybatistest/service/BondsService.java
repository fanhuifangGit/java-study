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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        BondsBean bondsBean1 = bondsDao.getBondsListById(bondsBean);
        return bondsBean1;
    }

    public Integer insert(BondsBean bondsBean) {
       return bondsDao.insert(bondsBean);
    }

    public void getBondsRedis(String type) {
        switch (Integer.parseInt(type)){
            case 1:
                log.info("==================string操作==========================");
                testRedisStringCommand();
                break;
            case 2:
                log.info("==================list操作============================");
                testRedisListCommand();
                break;
            case 3:
                log.info("====================hash操作==========================");
                testRedisHashCommand();
                break;
            case 4:
                log.info("====================set操作===========================");
                testRedisSetCommand();
                break;
            case 5:
                log.info("====================zset操作==========================");
                testRedisZSetCommand();
                break;
            default: return;
        }
    }

    public void testRedisStringCommand(){
        BondsBean bondsBean1 = new BondsBean();
        bondsBean1.setBondId(4);
        bondsBean1.setBondCode("创370016");
        bondsBean1.setBondName("北陆发债");
        bondsBean1.setBondType(1);
        bondsBean1.setApplyTime((int) getNowSeconds());
        bondsBean1.setApplyNumber("1000手");
        bondsBean1.setGivenMoney("1000");
        bondsBean1.setProfit("100");
        bondsBean1.setBeListsTime((int) getNowSeconds());
        bondsBean1.setId(1000);
        String redisKey = String.format("%s:%s","bondId","bondName");
        String value = (String) redisTemplate.opsForValue().get(redisKey);
        List<BondsBean> list = JSON.parseArray(value,BondsBean.class);
        if(null==list){
             list =  new ArrayList<>();
        }
        list.add(bondsBean1);
        String redisValue = JSONObject.toJSONString(list);
        redisTemplate.opsForValue().set(redisKey,redisValue);
        log.info("========get获取value========={}",redisTemplate.opsForValue().get(redisKey));
        log.info("========getAndSet==========={}",redisTemplate.opsForValue().getAndSet("string1","value1"));
        log.info("========expire=============={}",redisTemplate.expire("string1",3L, TimeUnit.MILLISECONDS));
        log.info("========persist============={}",redisTemplate.persist("string1"));
        log.info("========hasKey=============={}",redisTemplate.hasKey("string1"));
        log.info("========getExpire==========={}",redisTemplate.getExpire("string1"));
        log.info("========setIfAbsent========={}",redisTemplate.opsForValue().setIfAbsent("string1","value2"));
        log.info("========setIfPresent========{}",redisTemplate.opsForValue().setIfPresent("string3","value3"));
        log.info("========get================={}",redisTemplate.opsForValue().get("string3"));
        redisTemplate.opsForValue().set("score","1000");
        log.info("========type================{}",redisTemplate.type("score"));
        log.info("========increment==========={}",redisTemplate.opsForValue().increment("score",100));
        log.info("========score==============={}",redisTemplate.opsForValue().get("score"));
        log.info("========score==============={}",redisTemplate.opsForValue().decrement("score"));
        log.info("========score==============={}",redisTemplate.opsForValue().decrement("score"),200);
        log.info("========get============={}",redisTemplate.opsForValue().get("string1"));
        log.info("========delete=============={}",redisTemplate.delete("string1"));
        log.info("========get================={}",redisTemplate.opsForValue().get("string1"));
        redisTemplate.opsForValue().set("mystr","mystrvalue");
        log.info("========append=============={}",redisTemplate.opsForValue().append("mystr1","mystrvalue1"));
        log.info("========get================={}",redisTemplate.opsForValue().get("mystr"));
        log.info("========get================={}",redisTemplate.opsForValue().get("mystr1"));
        log.info("========size================{}",redisTemplate.opsForValue().size("mystr"));
        log.info("========size================{}",redisTemplate.opsForValue().size("mystr1"));
    }
    /**
     * redisTemplate.opsForList();//操作list
     **/
    
    public void testRedisListCommand(){
        List<String> list1 =  new ArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        redisTemplate.opsForList().leftPush("listkey1", JSONObject.toJSONString(list1));
        redisTemplate.opsForList().rightPush("listkey2","33333333");
        redisTemplate.opsForList().rightPopAndLeftPush("listkey2","3333333333");
        String[] strings =  new String[]{"asd","fgh","jkl"};
        redisTemplate.opsForList().rightPushAll("listkey2",strings);
        log.info("======================={}", redisTemplate.opsForList().range("listkey2",0,-1));
        log.info("======================={}", redisTemplate.opsForList().leftPop("listkey2"));

    }
    /**
     * redisTemplate.opsForHash();//操作hash
     **/
    
    public void testRedisHashCommand(){
        redisTemplate.opsForHash().put("h1","h2","v1");
        redisTemplate.opsForHash().put("redishash","name","tom");
        Map<String, String> map =  new HashMap<>();
        map.put("hash1","value1");
        map.put("hash2","value2");
        redisTemplate.opsForHash().putAll("hashMap",map);
        log.info("========================={}",redisTemplate.opsForHash().get("redishash","name"));
        log.info("========================={}",redisTemplate.opsForHash().get("hashMap","hash1"));
        log.info("========keys============={}",redisTemplate.opsForHash().keys("hashMap"));
        log.info("========size============={}",redisTemplate.opsForHash().size("hashMap"));
        log.info("========entries=========={}",redisTemplate.opsForHash().entries("hashMap"));
    }
    /**
     * redisTemplate.opsForSet();//操作set
     **/
    
    public void testRedisSetCommand(){
          String[] strings =  new  String[]{"aaaa","bbbb","cccc","dddd"};
        redisTemplate.opsForSet().add("setKey",strings);
        redisTemplate.opsForSet().add("setKey1","eeee");
        redisTemplate.opsForSet().add("setKey2","ffff");
        redisTemplate.opsForSet().add("setKey3","hhhh");
        redisTemplate.opsForSet().add("setKey3","iiii");
        redisTemplate.opsForSet().add("setKey3","cccc");

        log.info("=========difference============{}", redisTemplate.opsForSet().difference("setKey2","setKey1"));
        log.info("=========union================={}", redisTemplate.opsForSet().union("setKey2","setKey1"));
        log.info("=========unionAndStore========={}", redisTemplate.opsForSet().unionAndStore("setKey2","setKey1","setKey1-setKey2-union"));
        log.info("=========members==============={}", redisTemplate.opsForSet().members("setKey"));
        log.info("=========isMember=============={}", redisTemplate.opsForSet().isMember("setKey","bbbb"));
        log.info("=========opsForSet============={}", redisTemplate.opsForSet().size("setKey"));
        log.info("=========pop==================={}", redisTemplate.opsForSet().pop("setKey1"));
        log.info("=========members==============={}", redisTemplate.opsForSet().members("setKey2"));
        log.info("=========members==============={}", redisTemplate.opsForSet().members("setKey3"));
        log.info("=========remove================{}", redisTemplate.opsForSet().remove("setKey3","hhhhhhh"));
        log.info("=========members==============={}", redisTemplate.opsForSet().members("setKey3"));
        log.info("=========randomMember=========={}", redisTemplate.opsForSet().randomMember("setKey"));
        log.info("=========members==============={}", redisTemplate.opsForSet().members("setKey"));
        log.info("=========members==============={}", redisTemplate.opsForSet().intersectAndStore("setKey","setKey3","setKey-setKey3-intersect"));
        log.info("=========members==============={}", redisTemplate.opsForSet().members("setKey-setKey3-intersect"));
    }
    /**
     * redisTemplate.opsForZSet();//操作有序set
     **/
    
    public void testRedisZSetCommand(){
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

        log.info("======add=zset1============{}",redisTemplate.opsForZSet().add("zset1",tuples));
        log.info("======add=zset2============{}",redisTemplate.opsForZSet().add("zset2",stuples1));
        log.info("======range================{}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======zCard================{}",redisTemplate.opsForZSet().zCard("zset1"));
        log.info("======incrementScore======={}",redisTemplate.opsForZSet().incrementScore("zset1","zset-1",1.1));
        log.info("======intersectAndStore===={}",redisTemplate.opsForZSet().intersectAndStore("zset1","zset2", "zset1-zset2-intersect"));
        log.info("======range================{}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======rangeByScore========={}",redisTemplate.opsForZSet().rangeByScore("zset1",0,5));
        log.info("======reverseRange========={}",redisTemplate.opsForZSet().reverseRange("zset1",0,-1));
        log.info("======reverseRangeByScore=={}",redisTemplate.opsForZSet().reverseRangeByScore("zset1",0,-1));
        log.info("======count================{}",redisTemplate.opsForZSet().count("zset1",0,-1));
        log.info("======rank================={}",redisTemplate.opsForZSet().rank("zset1","zset-1"));
        log.info("======size================={}",redisTemplate.opsForZSet().size("zset1"));


    }
    public  static long getNowSeconds(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli()/1000;
    }


}
