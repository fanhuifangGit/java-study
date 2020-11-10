package com.fanhf.javastudy.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-11-10 11:01
 */
public class MathUtil {
    public MathUtil() {
    }

    public static void main(String[] args) {
        System.out.println("1:" + getSecurityCOde());
        System.out.println("2:" + getRandomString(4));
        System.out.println("3:" + getRandom620(5));
        System.out.println("4:" + getMD5("fhf"));
    }

    public static String getSecurityCOde() {
        return UUID.randomUUID().toString();
    }

    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }

        return stringBuffer.toString();
    }

    public static String getRandom620(Integer length) {
        String result = "";
        Random random = new Random();
        int n = 20;
        if (null != length && length > 0) {
            n = length;
        }

        int randInt = 0;

        for(int i = 0; i < n; ++i) {
            randInt = random.nextInt(10);
            result = result + randInt;
        }

        return result;
    }

    public static String getMD5(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StringBuff = new StringBuffer();

        for(int i = 0; i < byteArray.length; ++i) {
            if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                md5StringBuff.append("0").append(Integer.toHexString(255 & byteArray[i]));
            } else {
                md5StringBuff.append(Integer.toHexString(255 & byteArray[i]));
            }
        }

        return md5StringBuff.toString();
    }
}
