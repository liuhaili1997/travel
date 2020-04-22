package co.xingguo.travelmanage.exception;


import co.xingguo.travelmanage.enums.InterfaceCustomizeErrorEnums;

/**
 * 捕获异常 处理一些捕获的异常提示前段
 * @author Created by hailitortoise on 2020-04-08
 * 继承RuntimeException 是为了项目再调用的时候不报异常中断，只是再advice中捕获
 */
public class CustomizeException extends RuntimeException {

    /**
     * 信息
     */
    private String message;

    /**
     * 状态码
     */
    private Integer code;

    public CustomizeException(InterfaceCustomizeErrorEnums enums) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
