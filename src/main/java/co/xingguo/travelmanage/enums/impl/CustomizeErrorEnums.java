package co.xingguo.travelmanage.enums.impl;

import co.xingguo.travelmanage.enums.InterfaceCustomizeErrorEnums;

/**
 * 错误码对应的枚举
 * @author Created by hailitortoise on 2020-04-08
 */
public enum CustomizeErrorEnums implements InterfaceCustomizeErrorEnums {
    /*每一个页面对应的异常需要区分开*/
    USER_RECORD_IS_EXIT(2001,"这个萝卜坑已经有人了，请用新的邮箱或用户名注册一个账号吧"),
    VIEW_CREATE_IS_FAIL(2002,"景区记录插入不成功，请重新输入"),
    HOTEL_CREATE_IS_FAIL(2003,"酒店未发布成功，请重新输入"),

    NOT_LOGIN(3001,"急什么，不会走就想跑，开区登录账号，不然不给你权限哦！！"),
    SYSTEM_ERROR(3002,"服务端系统异常...我已乏，明天我再解决！！！")
    ;


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    CustomizeErrorEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
