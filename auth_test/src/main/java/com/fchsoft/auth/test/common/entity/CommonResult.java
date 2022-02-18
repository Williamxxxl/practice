package com.fchsoft.auth.test.common.entity;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fchsoft.auth.test.common.constant.SysConstant;
import lombok.Data;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName CommonResult.java
 * @Description
 * @createTime 2022-01-16 13:09
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;
    @JsonIgnore
    private Throwable exception;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult() {
        this(null, null);
    }

    public static CommonResult ok(String message) {
        return new CommonResult(SysConstant.OK, message);
    }

    public static CommonResult ok() {
        return new CommonResult(SysConstant.OK, SysConstant.OK_MSG);
    }

    public static CommonResult error(String message) {
        return new CommonResult(SysConstant.ERROR, message);
    }

    public static CommonResult error() {
        return new CommonResult(SysConstant.ERROR, SysConstant.ERROR_MSG);
    }

    public CommonResult data(T t) {
        this.setData(t);
        return this;
    }

    public CommonResult exception(Throwable exception) {
        this.setException(exception);
        return this;
    }

    public String getException() {
        if (this.exception == null) {
            return null;
        }
        return ExceptionUtil.stacktraceToString(this.exception, Integer.MAX_VALUE);
    }

    @JsonIgnore
    public boolean isOk() {
        return this.code.equals(SysConstant.OK);
    }

    @Override
    public String toString() {
        return JSONUtil.parse(this).toString();
    }
}
