package co.xingguo.travelmanage.enums;

/**
 * 用于对各个服务的枚举类继承，实现通用的
 * @author Created by hailitortoise on 2020-04-08
 */
public interface InterfaceCustomizeErrorEnums {

    /**
     * 获取CustomizeErrorEnums中的 信息
     * @return
     */
    String getMessage();

    /**
     * 获取CustomizeErrorEnums中的 状态码
     * @return
     */
    Integer getCode();
}
