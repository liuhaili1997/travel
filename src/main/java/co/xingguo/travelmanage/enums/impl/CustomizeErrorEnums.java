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
    VIEW_UPDATE_IS_FAIL(2003,"景区记录插入不成功，请重新输入"),
    VIEW_DELETE_IS_FAIL(2004,"执行删除操作失败，可能没有这条数据哦！！"),
    USER_IS_NOT_EXIT(2006,"用户不存在"),
    USER_UPDATE_IS_FAIL(2006,"用户更新失败！！"),

    VIEW_FIND_IS_NOT_EXIT(2005,"此纪录可能已删除，我脑海中每页它的存在"),

    HOTEL_CREATE_IS_FAIL(2010,"酒店未发布成功，请重新输入"),
    RESERVATION_CREATE_IS_FAIL(2011,"预定不成功！请重新预定！！"),
    RESERVATION_FIND_IS_NOT_EXIT(2012,"没有找到你的订单，请联系工作人员解决！！"),
    RESERVATION_DELETE_IS_FAIL(2013,"预约订单取消失败，请联系工作人员解决！！"),

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
