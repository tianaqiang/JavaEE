package com.ooda.util;

import lombok.Data;

/**
 * @Desc 返回对象
 * @Author 田阿强
 * @create 2022/10/10 19:25
 */

@Data
public class ReturnObject<T> {
    ResponseCode code = ResponseCode.OK;

    String errmsg = "成功";

    private T data = null;

    public ReturnObject() {
    }

    public ReturnObject(ResponseCode code) {
        this.code = code;
    }

    public ReturnObject(T data) {
        this();
        this.data = data;
    }

    public ReturnObject(ResponseCode code, String errmsg) {
        this.code = code;
        this.errmsg = errmsg;
    }

    public String getErrmsg() {
        if (this.errmsg != null) {
            return this.errmsg;
        } else {
            return this.code.getMessage();
        }
    }
}