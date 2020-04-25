package co.xingguo.travelmanage.dto;

import co.xingguo.travelmanage.model.User;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author Created by hailitortoise on 2020-04-23
 */
@Data
public class ViewDto {

    /**
     * id
     */
    private Long id;

    /**
     * 对应user中的accountId
     */
    private Long creator;

    /**
     * 标题
     */
    private String title;

    /**
     * 营业时间
     */
    private String openTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 票价
     */
    private BigDecimal price;

    /**
     * 特色的景区图片
     */
    private String imgUrl;

    /**
     * 浏览数
     */
    private Long viewCount;

    /**
     * 评论数
     */
    private Long commentCount;

    /**
     * 评分
     */
    private Double score;

    /**
     * 标记
     */
    private String tag;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 更新时间
     */
    private Long utime;

    /**
     * 描述
     */
    private String description;

    /**
     * 用户对象
     */
    private User user;
}
