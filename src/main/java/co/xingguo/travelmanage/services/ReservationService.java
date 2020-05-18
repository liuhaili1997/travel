package co.xingguo.travelmanage.services;

import co.xingguo.travelmanage.dto.PageInformationDto;

/**
 * 预定的实现类
 * @author Created by hailitortoise on 2020-05-17
 */

public interface ReservationService {

    /**
     * 获取数据
     *
     *
     * @param currentPage 当前页
     * @param pageSize 分页大小
     * @param search 查询条件
     * @return
     */
    PageInformationDto list(Integer currentPage, Integer pageSize, String search);
}
