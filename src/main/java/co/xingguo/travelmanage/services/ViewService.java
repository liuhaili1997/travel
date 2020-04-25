package co.xingguo.travelmanage.services;

import co.xingguo.travelmanage.dto.PageInformationDto;
import co.xingguo.travelmanage.dto.ViewDto;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.User;

import java.util.List;

/**
 * 景区的实现业务
 * @author Created by hailitortoise on 2020-04-22
 */
public interface ViewService {

    /**
     * 保存发布的景区信息
     *
     * @param landscape 前端的值
     * @param user    当前的用户
     * @return 返回插入状态
     */
    void createOrUpdateRecord(Landscape landscape, User user);

    /**
     * 分页获取数据--景区
     *
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @param search      搜索条件
     * @return 结果
     */
    PageInformationDto list(Integer currentPage, Integer pageSize, String search);

    /**
     * 根据id查询景点的相关信息和管理员的信息
     *
     * @param id id
     * @return 对象结果
     */
    ViewDto getById(Long id);

    /**
     * 根据tag查询相关主题的
     * @param viewDto 对象
     * @return 结果集合
     */
    List<ViewDto> selectRelated(ViewDto viewDto);
}
