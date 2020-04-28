package co.xingguo.travelmanage.dto;

import lombok.Data;

/**
 *
 * @author Created by hailitortoise on 2020-04-28
 */
@Data
public class UserDto {


    /**
     * id
     */
    private Long id;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * token
     */
    private String token;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 更新时间
     */
    private Long utime;
}


