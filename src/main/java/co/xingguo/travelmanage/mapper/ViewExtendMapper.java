package co.xingguo.travelmanage.mapper;

import co.xingguo.travelmanage.dto.QuestionQueryDto;
import co.xingguo.travelmanage.model.Landscape;

import java.util.List;

/**
 * 景区搜索的拓展查询
 * @author Created by hailitortoise on 2020-04-23
 */
public interface ViewExtendMapper {

    /**
     * 重写获取总数的查询，可以通过正则表达式来匹配数据是否符合的数量
     * @param questionQueryDto 查询聚合类
     * @return 数量
     */
    Integer countByExample(QuestionQueryDto questionQueryDto);

    /**
     * 根据search生成新的查询语句 可以分页和排序根据ctime
     * @param questionQueryDto 查询聚合类
     * @return 数量
     */
    List<Landscape> selectBySearch(QuestionQueryDto questionQueryDto);

    /**
     * 通过正则来查询相类似主题景点
     *
     * @param landscape 景点对象
     * @return 相关的集合
     */
    List<Landscape> selectRelated(Landscape landscape);

    /**
     * 增加阅读数量
     *
     * @param landscape 导游对象
     */
    void incViewCount(Landscape landscape);

    /**
     * 增加订单数
     *
     * @param landscape 导游对象
     */
    void incCommentCount(Landscape landscape);
}
