package com.fanhf.javastudy;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fanhf
 * @Description 年龄枚举类
 * @date 2020-12-28 10:55
 */

public enum AgeEnum {

    YOUNG(1, "16~25"),
    MID(2,"26~35"),
    MID_OLD(3,"36~55"),
    OLD(4,"56 以上"),
    ;
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    AgeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getAgeNameByCode(Integer code){
        if (code == null || StringUtils.isEmpty(code.toString())) {
            return null;
        }
        for (AgeEnum ageEnum: AgeEnum.values()) {
            if (code.equals(ageEnum.getCode())) {
                return ageEnum.getName();
            }
        }
        return null;
    }
    public static Integer getAgeNameCode(String name){
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (AgeEnum ageEnum: AgeEnum.values()) {
            if (name.equals(ageEnum.getName())) {
                return ageEnum.getCode();
            }
        }
        return null;
    }
}

