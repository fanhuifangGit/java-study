package com.fanhf.javastudy.utils;


import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fanhf
 * @Description 小米的文本处理面试题解题
 * @date 2020-11-05 10:56
 */

public class TextUtils {
    public static void main(String[] args){
        String str = "how are you i am fine thanks";
        System.out.println("计算文本的长度:"+textSize(str));
        System.out.println("以空格分隔后,计算文本中单词的数量:"+howManyWords(str));
        System.out.println("计算文本中最常出现的字母的出现次数:"+mostUsedLetter(str));
        System.out.println("将文本中单词按字典排序:"+sortWords(str));
        System.out.println("去掉文本中所有a开头的单词:"+filterWords(str));
    }

    //  计算文本的长度
    //  样例输入
    //  "how are you i am fine thanks"
    //  样例输出
    //  28
    public static int textSize(String text) {
        int length =  text.length();
        return length;
    }

    //  文本由空格隔开的小写字母单词组成。计算文本中单词的数量
    //  样例输入
    //  "how are you i am fine thanks"
    //  样例输出
    //  7
    public static int howManyWords(String text) {
        String[] t =  text.split(String.valueOf((char)32));
        return t.length;
    }

    //  文本由空格隔开的小写字母单词组成。计算文本中最常出现的字母的出现次数
    //  样例输入
    //  "how are you i am fine thanks"
    //  样例输出
    //  3
    public static int mostUsedLetter(String text){
        if("".equals(text)|| null ==text){
            return 0;
        }
        String[] str = text.split(String.valueOf((char)32));
        List<Character> list = new ArrayList<Character>();
        for (int j = 0;j < str.length;j++){
            for (int i = 0; i<str[j].length();i++){
                list.add(str[j].charAt(i));
            }
        }
        //map中不能存放相同的key
        Map<Character, Integer> map =  new HashMap<>();
        for (Character ch : list){
            Integer count = 1;
            //map中包含某个字符，计数器就加1
            if(null != map.get(ch)){
                count = map.get(ch)+1;
            }
            map.put(ch,count);
        }
        //这里我用了java8的stream流和Lambda表达式
        Optional<Integer> op =
                map.values()
                        .stream()
                        .collect(
                                Collectors.maxBy((i1, i2) -> Integer.compare(i1,i2)));

        return op.get();
    }

    //
    //  文本由空格隔开的小写字母单词组成。将文本中单词按字典排序
    //  样例输入
    //  "how are you i am fine thanks"
    //  样例输出
    //  "am are fine how i thanks you"
    //此题解法来自于：https://blog.csdn.net/weixin_44084434/article/details/93711748 感谢
    public static String sortWords(String text) {
        if("".equals(text)|| null ==text){
            return "";
        }

        String[] str = text.split(String.valueOf((char)32));
        List<String> list = new ArrayList<>(str.length);
        for(int i = 0; i < str.length;i++){
            list.add(str[i]);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    String str1 = new String(o1.toString()
                            .getBytes("GB2312"),"ISO-8859-1");
                    String str2 = new String(o2.toString()
                            .getBytes("GB2312"),"ISO-8859-1");
                    return str1.compareTo(str2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < list.size();i++){
            stringBuilder.append(list.get(i)).append(String.valueOf((char)32));
        }
        return  stringBuilder.toString();
    }

    //  文本由空格隔开的小写字母单词组成。去掉文本中所有a开头的单词
    //  样例输入
    //  "how are you i am fine thanks"
    //  样例输出
    //  "how you i fine thanks"
    public static String filterWords(String text) {
        if("".equals(text)|| null ==text){
            return "";
        }
        String[] str = text.split(String.valueOf((char)32));
        List<String> list = new ArrayList<>(str.length);
        for(int i = 0; i < str.length;i++){
            if(!str[i].startsWith("a")){
                list.add(str[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < list.size();i++){
            stringBuilder.append(list.get(i)).append(String.valueOf((char)32));
        }
        return  stringBuilder.toString();
    }
}


