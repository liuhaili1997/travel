package co.xingguo.travelmanage.services;

import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.User;

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
    void createViewRecord(Landscape landscape, User user);
}
