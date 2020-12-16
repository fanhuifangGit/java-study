package com.fanhf.javastudy.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-15 17:25
 */
public class InfoSecretHandle {
    public static void main(String[] args) {
       System.out.println( getCardNumber("411424199209172825"));
       System.out.println(getName("范慧芳"));
    }

    /**
     * 用户身份证号脱敏
     * @return
     */
    public static String getCardNumber(String cardNumber) {
        if (StringUtils.isEmpty(cardNumber) || StringUtils.isBlank(cardNumber)) {
            return null;
        }
        return StringUtils.left(cardNumber, 1) + "****************" + StringUtils.right(cardNumber, 1);
    }

    /**
     * 用户真实姓名脱敏
     * @return
     */
    public static String getName(String name) {
        if (StringUtils.isEmpty(name) || StringUtils.isBlank(name)) {
            return null;
        }
        switch (name.length()) {
            case 2:
                return StringUtils.left(name, 1) + "*";
            case 3:
                return StringUtils.left(name, 1) + "**";
            case 4:
                return StringUtils.left(name, 1) + "***";
            default:
                return StringUtils.left(name, 1) + "**";
        }
    }
}   
