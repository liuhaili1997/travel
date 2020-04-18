package co.xingguo.travelmanage.enums;
/**
 * 对应的是User中的type类型
 * @author Created by hailitortoise on 2020-04-18
 */
public enum UserTypeEnums {
    ORDINARY_PEOPLE(0, "游客"),
    Manager(1, "管理者");

    private Integer code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    UserTypeEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
