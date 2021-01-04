package com.fanhf.javastudy;

import com.alibaba.fastjson.JSONObject;
import com.fanhf.javastudy.utils.ObjectMapperUtils;

import java.io.Serializable;
import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2020-12-28 11:03
 */

public class ResultData<T extends ResultBean> implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    public static final String CODE_SUCCESS = "200";
    public static final String CODE_FAIL = "500";
    private String code;
    private String message;
    private T object;
    private List<T> list;

    public ResultData() {
        this.code = "200";
        this.message = "";
    }

    public ResultData(String code) {
        this(code, (String)null);
    }

    public ResultData(String code, String message) {
        this(code, message, null);
    }

    public ResultData(String code, String message, T object) {
        this.code = "200";
        this.message = "";
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public String getCode() {
        return this.code;
    }

    public ResultData<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ResultData<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getObject() {
        return this.object;
    }

    public ResultData<T> setObject(T object) {
        this.object = object;
        return this;
    }

    public ResultData<T> setObject(JSONObject data, Class<T> t) {
        try {
            this.object = (T) ObjectMapperUtils.json2object(data, t);
            return this;
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public List<T> getList() {
        return this.list;
    }

    public ResultData<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public ResultData<T> setList(List<JSONObject> rows, Class<T> t) {
        try {
            this.list = ObjectMapperUtils.json2objects(rows, t);
            return this;
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }
}
