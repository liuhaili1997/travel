package co.xingguo.travelmanage.dto;

import lombok.Data;

import java.util.List;

/**
 * tag的集合类
 * @author Created by hailitortoise on 2020-04-23
 */
@Data
public class TagDto {

    /**
     * 上级目录
     */
    private String categoryName;

    /**
     * tag标签
     */
    private List<String> tags;
}
