package com.fchsoft.auth.test.common.constant;

/**
 * @author wei_xl
 * 2020/10/10 09:32
 */
public class SysConstant {
    /**
     * 请求反回成功标志
     */
    public static int OK = 1;

    /**
     * 请求反回成功信息
     */
    public static String OK_MSG = "操作成功";
    /**
     * 保存请求反回成功信息
     */
    public static String OK_SAVE = "保存成功";
    /**
     * 更新请求反回成功信息
     */
    public static String OK_UPDATE = "更新成功";
    /**
     * 删除请求反回成功信息
     */
    public static String OK_DEL = "删除成功";
    /**
     * 请求反回失败标志
     */
    public static int ERROR = 0;
    /**
     * 请求反回失败信息
     */
    public static String ERROR_MSG = "操作失败";
    /**
     * 保存请求反回失败信息
     */
    public static String ERROR_SAVE = "保存失败";
    /**
     * 更新请求反回失败信息
     */
    public static String ERROR_UPDATE = "更新失败";
    /**
     * 删除请求反回失败信息
     */
    public static String ERROR_DEL = "删除失败";

    /**
     * 数据已经存在
     */
    public static String DATA_EXIST = "数据已经存在";

    /**
     * 默认 pageNumger
     */
    public static int PAGE_NUMBER = 1;
    /**
     * 默认 pageSize
     */
    public static int PAGE_SIZE = 15;

    /**
     * 删除标识-未删除
     */
    public static final Integer DELETED_NO = 0;

    /**
     * 删除标识-已删除
     */
    public static final Integer DELETED_YES = 1;

    public static final Long SYS_ENT_ID = 0L;

    public static final long AUTH_EXPIRATION_TIME = 60 * 60 * 24;

}
