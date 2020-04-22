package co.xingguo.travelmanage.services;

import co.xingguo.travelmanage.model.Hotel;
import co.xingguo.travelmanage.model.User;

/**
 * 酒店实体类
 * @author Created by hailitortoise on 2020-04-22
 */
public interface HotelService {

    /**
     * 创建酒店记录
     *
     * @param hotel 酒店对象
     * @param users 当前用户信息
     */
    void createHotelRecord(Hotel hotel, User users);
}
