package co.xingguo.travelmanage.services;

import co.xingguo.travelmanage.model.User;

/**
 * 实现用户表的查询和各种操作
 * @author Created by hailitortoise on 2020-04-18
 */
public interface UserService {

    /**
     * 创建或更新用户记录
     * @param user 接受数据对象
     */
    void createOrUpdateUser(User user);
}
