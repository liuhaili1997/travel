package co.xingguo.travelmanage.controller;

import co.xingguo.travelmanage.dto.ResultDto;
import co.xingguo.travelmanage.enums.impl.CustomizeErrorEnums;
import co.xingguo.travelmanage.exception.CustomizeException;
import co.xingguo.travelmanage.mapper.LandscapeMapper;
import co.xingguo.travelmanage.mapper.ReservationMapper;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.Reservation;
import co.xingguo.travelmanage.model.ReservationExample;
import co.xingguo.travelmanage.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 预约订单
 * @author Created by hailitortoise on 2020-05-17
 */
@Controller
public class ReservationController {

    @Autowired
    private LandscapeMapper landscapeMapper;

    @Autowired
    private ReservationMapper reservationMapper;


    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String reservationView(@PathVariable(name = "id") Long id,
                                  HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (null == user) {
            return "login";
        }
        Landscape landscape = landscapeMapper.selectByPrimaryKey(id);
        if (null == landscape) {
            throw new CustomizeException(CustomizeErrorEnums.VIEW_FIND_IS_NOT_EXIT);
        }
        Reservation reservation = new Reservation();
        reservation.setUserId(user.getAccountid());
        reservation.setViewId(landscape.getId());
        reservation.setViewName(landscape.getTitle());
        reservation.setViewPrice(landscape.getPrice());
        reservation.setUserName(user.getName());
        reservation.setEmail(user.getEmail());
        String phone = user.getPhone();
        if (StringUtils.isNotBlank(phone)) {
            reservation.setPhone(phone);
        }
        long currentTime = System.currentTimeMillis();
        reservation.setCtime(currentTime);
        reservation.setUtime(currentTime);
        int insert = reservationMapper.insert(reservation);
        if (insert != 1) {
            throw new CustomizeException(CustomizeErrorEnums.RESERVATION_CREATE_IS_FAIL);
        }
        return "redirect:/";
    }

    @GetMapping("/reservation/delete/{id}")
    public String deleteReservationView(@PathVariable(name = "id") Long id, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            throw new CustomizeException(CustomizeErrorEnums.NOT_LOGIN);
        }
        Landscape landscape = landscapeMapper.selectByPrimaryKey(id);
        if (landscape == null) {
            throw new CustomizeException(CustomizeErrorEnums.VIEW_FIND_IS_NOT_EXIT);
        }
        ReservationExample reservationExample = new ReservationExample();
        reservationExample.createCriteria()
                .andUserIdEqualTo(user.getAccountid())
                .andViewIdEqualTo(id);
        List<Reservation> reservations = reservationMapper.selectByExample(reservationExample);
        if (CollectionUtils.isEmpty(reservations)) {
            throw new CustomizeException(CustomizeErrorEnums.RESERVATION_FIND_IS_NOT_EXIT);
        }
        int i = reservationMapper.deleteByExample(reservationExample);
        if (i != 1) {
            throw new CustomizeException(CustomizeErrorEnums.RESERVATION_DELETE_IS_FAIL);
        }
        return "redirect:/";
    }
}