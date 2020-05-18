package co.xingguo.travelmanage.dto;

import lombok.Data;

import java.math.BigDecimal;
/**
 *
 * @author Created by hailitortoise on 2020-05-18
 */
@Data
public class ReservationDto {

    /**
     * id
     */
    private Long id;

    /**
     * accountID
     */
    private Long userId;

    /**
     * 景点id
     */
    private Long viewId;

    /**
     * 景点名
     */
    private String viewName;

    /**
     * 价格
     */
    private BigDecimal viewPrice;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 更新时间
     */
    private Long utime;

    /**
     * 用户头像
     */
    private String avatar;
}
