package co.xingguo.travelmanage.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用于接收参数，publish中传过来的参数
 * @author Created by hailitortoise on 2020-04-19
 */
@Data
public class ViewDto {

    /**
     * 标题
     */
    private String title;

    /**
     * 营业时间间隔
     */
    private String openTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 描述
     */
    private String description;

    /**
     * tag
     */
    private String tag;
}
