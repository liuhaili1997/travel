package co.xingguo.travelmanage.services.impl;

import co.xingguo.travelmanage.dto.PageInformationDto;
import co.xingguo.travelmanage.dto.ReservationDto;
import co.xingguo.travelmanage.mapper.ReservationMapper;
import co.xingguo.travelmanage.mapper.UserMapper;
import co.xingguo.travelmanage.model.*;
import co.xingguo.travelmanage.services.ReservationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Created by hailitortoise on 2020-05-17
 */
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInformationDto list(Integer currentPage, Integer pageSize, String search) {
        PageInformationDto<ReservationDto> pageInformationDto = new PageInformationDto<>();
        ReservationExample reservationExample = new ReservationExample();
        if (StringUtils.isNotBlank(search)) {
            reservationExample.createCriteria()
                    .andUserNameEqualTo(search);
        }
        //根据查询获取具体的数量进行分页
        Integer total = (int)reservationMapper.countByExample(reservationExample);
        //获取总页数
        int totalPage;
        if (total % pageSize == 0) {
            totalPage = total / pageSize;
        } else {
            totalPage = total / pageSize + 1;
        }
        pageInformationDto.setTotalPage(totalPage);
        //健壮性
        if (currentPage < 1) {
            currentPage = 1;
        }
        //totalPage 总页数
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        //这里进行分页操作
        pageInformationDto.setPageInformation(total, currentPage, pageSize);

        //进行分页操作
        int offSize = currentPage < 1 ? 0 : pageSize * (currentPage - 1);
        //search 对应新的搜索查询
        reservationExample.setOrderByClause("ctime desc");
        List<Reservation> reservationList = reservationMapper
                .selectByExampleWithRowbounds(reservationExample, new RowBounds(offSize, pageSize));
        if (CollectionUtils.isEmpty(reservationList)) {
            return new PageInformationDto<>();
        }
        List<Long> accountId = reservationList.stream().map(Reservation::getUserId).collect(Collectors.toList());
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountidIn(accountId);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, String> userMap = users.stream().collect(Collectors.toMap(User::getAccountid, User::getAvatarUrl, (oldValue, newValue) -> newValue));
        List<ReservationDto> data = new ArrayList<>();
        ReservationDto reservationDto;
        for (Reservation reservation : reservationList) {
            reservationDto = new ReservationDto();
            BeanUtils.copyProperties(reservation, reservationDto);
            String avatar = userMap.get(reservation.getUserId());
            if (StringUtils.isNotBlank(avatar)) {
                reservationDto.setAvatar(avatar);
            }
            data.add(reservationDto);
        }
        pageInformationDto.setData(data);
        return pageInformationDto;
    }
}
