package co.xingguo.travelmanage.services.impl;

import co.xingguo.travelmanage.enums.impl.CustomizeErrorEnums;
import co.xingguo.travelmanage.exception.CustomizeException;
import co.xingguo.travelmanage.mapper.HotelMapper;
import co.xingguo.travelmanage.model.Hotel;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Created by hailitortoise on 2020-04-22
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public void createHotelRecord(Hotel hotel, User users) {
        hotel.setScore(0.0);
        Long accountId = users.getAccountid();
        if (null != accountId) {
            hotel.setCreator(accountId);
        }
        hotel.setCommentCount(0L);
        hotel.setViewCount(0L);
        Long currentTime = System.currentTimeMillis();
        hotel.setCtime(currentTime);
        hotel.setUtime(currentTime);
        int insert = hotelMapper.insert(hotel);
        if (insert != 1) {
            throw new CustomizeException(CustomizeErrorEnums.HOTEL_CREATE_IS_FAIL);
        }
        return;
    }
}
