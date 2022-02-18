package com.fchsoft.auth.test.common.entity;

import cn.hutool.core.util.ObjectUtil;
import com.fchsoft.auth.test.common.constant.SysConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName QueryRequest.java
 * @Description
 * @createTime 2022-01-16 18:46
 */
@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -4869594085374385813L;
    /**
     * 当前页面数据量
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;

    public Integer getPageNum() {
        return ObjectUtil.defaultIfNull(pageNum, SysConstant.PAGE_NUMBER);
    }

    public Integer getPageSize() {
        return ObjectUtil.defaultIfNull(pageSize, SysConstant.PAGE_SIZE);
    }

}
