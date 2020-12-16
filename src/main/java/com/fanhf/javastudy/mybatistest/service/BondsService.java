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
            case 0:
                log.info("==================Keys操作==========================");
                testRedisKeysCommand();
                break;
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

    /**
     * redisTemplate;//操作keys
     */
    public void testRedisKeysCommand(){
        log.info("========expire=============={}",redisTemplate.expire("string1",3L, TimeUnit.MILLISECONDS));
        log.info("========persist============={}",redisTemplate.persist("string1"));
        log.info("========hasKey=============={}",redisTemplate.hasKey("string1"));
        log.info("========getExpire==========={}",redisTemplate.getExpire("string1"));
        log.info("========type================{}",redisTemplate.type("score"));
        log.info("========delete=============={}",redisTemplate.delete("string1"));
    }

    /**
     * redisTemplate.opsForValue();//操作String
     **/
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
        log.info("========setIfAbsent========={}",redisTemplate.opsForValue().setIfAbsent("wwwwwwwwwww","value2"));
        log.info("========setIfPresent========{}",redisTemplate.opsForValue().setIfPresent("string3","value3"));
        log.info("========get================={}",redisTemplate.opsForValue().get("string3"));
        redisTemplate.opsForValue().set("score","1000");
        log.info("========increment==========={}",redisTemplate.opsForValue().increment("score",100));
        log.info("========score==============={}",redisTemplate.opsForValue().get("score"));
        log.info("========score==============={}",redisTemplate.opsForValue().decrement("score"));
        log.info("========score==============={}",redisTemplate.opsForValue().decrement("score"),200);
        log.info("========get============={}",redisTemplate.opsForValue().get("string1"));
        log.info("========delete=============={}",redisTemplate.delete("string1"));
        log.info("========get================={}",redisTemplate.opsForValue().get("string1"));
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

        list1.add("1111");
        list1.add("2222");
        list1.add("3333");
        list1.add("4444");
        log.info("=======leftPush============={}", redisTemplate.opsForList().leftPush("listkey1", JSONObject.toJSONString(list1)));
        log.info("=======range1==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        log.info("=======rightPush============{}", redisTemplate.opsForList().rightPush("listkey2","qqqq"));
        log.info("=======rightPush============{}", redisTemplate.opsForList().rightPush("listkey2","wwww"));
        log.info("=======rightPush============{}", redisTemplate.opsForList().rightPush("listkey2","eeee"));
        log.info("=======range2==============={}", redisTemplate.opsForList().range("listkey2",0,-1));
        log.info("=======leftPop=============={}", redisTemplate.opsForList().leftPop("listkey1"));
        log.info("=======leftPush============={}", redisTemplate.opsForList().leftPush("listkey1","aaaa"));
        log.info("=======leftPush============={}", redisTemplate.opsForList().leftPush("listkey1","  bbbb"));
        log.info("=======leftPush============={}", redisTemplate.opsForList().leftPush("listkey1","cccc"));
        log.info("=======leftPush============={}", redisTemplate.opsForList().leftPush("listkey1","  dddd"));
        log.info("=======leftPush============={}", redisTemplate.opsForList().leftPush("listkey1","ffff"));
        log.info("=======range3==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        //截取第1个到第4个元素
        redisTemplate.opsForList().trim("listkey1",0,3);
        log.info("=======range4==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        log.info("=======leftPop=============={}", redisTemplate.opsForList().leftPop("listkey1"));
        log.info("=======range5==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        log.info("=======rightPop============={}", redisTemplate.opsForList().rightPop("listkey1"));
        log.info("=======range6==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        log.info("=======size================={}", redisTemplate.opsForList().size("listkey1"));
        log.info("=======index================{}", redisTemplate.opsForList().index("listkey1",1));
        log.info("=======range7==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        log.info("=======remove==============={}", redisTemplate.opsForList().remove("listkey1",0,"cccc"));
        log.info("=======range8==============={}", redisTemplate.opsForList().range("listkey1",0,-1));
        //从listkey2（[qqqq, wwww, eeee]）取出右边第一个给元素，放到listkey3里
        log.info("=======rightPopAndLeftPush=={}",  redisTemplate.opsForList().rightPopAndLeftPush("listkey2","listkey3"));
        //[qqqq, wwww]
        log.info("=======range9==============={}", redisTemplate.opsForList().range("listkey2",0,-1));
        //[eeee]
        log.info("=======range10==============={}", redisTemplate.opsForList().range("listkey3",0,-1));
        //如果listkey3存在的话，将下标为0的改为”1111“
        redisTemplate.opsForList().set("listkey3",0,"1111");
        //如果listkey3存在的话，将下标为0的改为”qqqq“
        redisTemplate.opsForList().set("listkey3",0,"qqqq");
        log.info("=======range11=============={}", redisTemplate.opsForList().range("listkey3",0,-1));
        //如果listkey3存在的话，在左边添加”6666“
        log.info("=======leftPushIfPresent===={}", redisTemplate.opsForList().leftPushIfPresent("listkey3","6666"));
        log.info("=======range12=============={}", redisTemplate.opsForList().range("listkey3",0,-1));

        String[] strings1 =  new String[]{"asd","fgh","jkl"};
        log.info("=======rightPushAll========={}",redisTemplate.opsForList().rightPushAll("listkey2",strings1));
        log.info("=======range13=============={}", redisTemplate.opsForList().range("listkey2",0,-1));
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
        redisTemplate.opsForHash().put("hash1","h1k1","v1");
        redisTemplate.opsForHash().put("hash1","h1k2","v2");
        log.info("========entries============={}",redisTemplate.opsForHash().entries("hash1"));
        redisTemplate.opsForHash().put("redishash","name","tom");
        log.info("=========get1==============={}",redisTemplate.opsForHash().get("redishash","name"));
        Map<String, String> map1 =  new HashMap<>();
        map1.put("hashMapKey1","hashMapValue1");
        map1.put("hashMapKey2","hashMapValue2");
        redisTemplate.opsForHash().putAll("hashMap",map1);
        log.info("========entries============={}",redisTemplate.opsForHash().entries("hashMap"));
        log.info("========get2================{}",redisTemplate.opsForHash().get("hashMap","hashMapKey2"));
        redisTemplate.opsForHash().put("hincrby","number","5");
        log.info("========increment==========={}",redisTemplate.opsForHash().increment("hincrby","number",10L));
        log.info("========putIfAbsent========={}",redisTemplate.opsForHash().putIfAbsent("redishash1","hash","absent"));
        log.info("========get3================{}",redisTemplate.opsForHash().get("redishash1","hash"));
        log.info("========lengthOfValue======={}",redisTemplate.opsForHash().lengthOfValue("hashMap","hashMapKey1"));
        log.info("========delete=============={}",redisTemplate.opsForHash().delete("hash1","h1k1"));
        log.info("========get3================{}",redisTemplate.opsForHash().get("hash1","h1k1"));
        log.info("========keys================{}",redisTemplate.opsForHash().keys("hashMap"));
        log.info("========size================{}",redisTemplate.opsForHash().size("hashMap"));
        log.info("========size================{}",redisTemplate.opsForHash().hasKey("hincrby","number"));
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
        redisTemplate.opsForSet().add("setKey3","llll");
        redisTemplate.opsForSet().add("setKey3","aaaa");

        log.info("=========difference============{}", redisTemplate.opsForSet().difference("setKey2","setKey1"));
        log.info("=========differenceAndStore===={}", redisTemplate.opsForSet().differenceAndStore("setKey2","setKey1","diffKey2"));
        log.info("=========members1=============={}", redisTemplate.opsForSet().members("diffKey2"));
        log.info("=========union================={}", redisTemplate.opsForSet().union("setKey2","setKey1"));
        log.info("=========unionAndStore========={}", redisTemplate.opsForSet().unionAndStore("setKey2","setKey1","setKey1-setKey2-union"));
        log.info("=========members2=============={}", redisTemplate.opsForSet().members("setKey1-setKey2-union"));
        log.info("=========isMember=============={}", redisTemplate.opsForSet().isMember("setKey","bbbb"));
        log.info("=========size=================={}", redisTemplate.opsForSet().size("setKey"));
        //pop是随机弹出某个元素，弹出后就不存在了
        log.info("=========pop==================={}", redisTemplate.opsForSet().pop("setKey3"));
        log.info("=========members3=============={}", redisTemplate.opsForSet().members("setKey3"));
        //不存在就返回0，存在则返回1
        log.info("=========remove================{}", redisTemplate.opsForSet().remove("setKey3","hhhhhhh"));
        log.info("=========move=================={}", redisTemplate.opsForSet().move("setKey1","eeee","setKey2"));
        log.info("=========members4=============={}", redisTemplate.opsForSet().members("setKey2"));
        log.info("=========randomMember=========={}", redisTemplate.opsForSet().randomMember("setKey"));
        log.info("=========members5=============={}", redisTemplate.opsForSet().members("setKey"));
        log.info("=========intersect============={}", redisTemplate.opsForSet().intersect("setKey","setKey3"));
        log.info("=========intersectAndStore====={}", redisTemplate.opsForSet().intersectAndStore("setKey","setKey3","setKey-setKey3-intersect"));
        log.info("=========members6=============={}", redisTemplate.opsForSet().members("setKey-setKey3-intersect"));
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

        ZSetOperations.TypedTuple<String> tuples1 = new DefaultTypedTuple<String>("zset-1",8.1);
        ZSetOperations.TypedTuple<String> tuples2 = new DefaultTypedTuple<String>("zset-2",8.2);
        ZSetOperations.TypedTuple<String> tuples3 = new DefaultTypedTuple<String>("zset-3",8.3);
        Set<ZSetOperations.TypedTuple<String>> stuples1 = new HashSet<ZSetOperations.TypedTuple<String>>();
        stuples1.add(tuples1);
        stuples1.add(tuples2);
        stuples1.add(tuples3);

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

        log.info("======range1==============={}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======zCard================{}",redisTemplate.opsForZSet().zCard("zset1"));
        log.info("======incrementScore======={}",redisTemplate.opsForZSet().incrementScore("zset1","zset-1",1.1));
        log.info("======intersectAndStore===={}",redisTemplate.opsForZSet().intersectAndStore("zset1","zset2", "zset1-zset2-intersect"));
        log.info("======range21=============={}",redisTemplate.opsForZSet().range("zset1-zset2-intersect",0,-1));
        log.info("======rangeByScore========={}",redisTemplate.opsForZSet().rangeByScore("zset2",8.1,8.3));
        log.info("======score================{}",redisTemplate.opsForZSet().score("zset2","zset-1"));
        log.info("======reverseRange========={}",redisTemplate.opsForZSet().reverseRange("zset1",0,-1));
        log.info("======range2==============={}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======reverseRangeByScore=={}",redisTemplate.opsForZSet().reverseRangeByScore("zset1",9.4,9.2));
        log.info("======range3==============={}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======reverseRank=========={}",redisTemplate.opsForZSet().reverseRank("zset1","zset-3"));
        log.info("======range4==============={}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======count================{}",redisTemplate.opsForZSet().count("zset1",9.2,9.6));
        log.info("======unionAndStore========{}",redisTemplate.opsForZSet().unionAndStore("zset1","zset2","zset1-zset2-union"));
        log.info("======range5==============={}",redisTemplate.opsForZSet().range("zset1-zset2-union",0,-1));
        log.info("======rank================={}",redisTemplate.opsForZSet().rank("zset1","zset-2"));
        log.info("======remove==============={}",redisTemplate.opsForZSet().remove("zset1","zset-2"));
        log.info("======range6==============={}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======removeRangeByScore==={}",redisTemplate.opsForZSet().removeRangeByScore("zset1-zset2-union",9.1,9.4));
        log.info("======range7==============={}",redisTemplate.opsForZSet().range("zset1",0,-1));
        log.info("======size================={}",redisTemplate.opsForZSet().size("zset1"));
        log.info("======zCard================{}",redisTemplate.opsForZSet().zCard("zset1"));
    }
    public  static long getNowSeconds(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli()/1000;
    }


}
