package co.xingguo.travelmanage.services.impl;

import co.xingguo.travelmanage.enums.impl.CustomizeErrorEnums;
import co.xingguo.travelmanage.exception.CustomizeException;
import co.xingguo.travelmanage.mapper.LandscapeMapper;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现类
 * @author Created by hailitortoise on 2020-04-22
 */
@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    private LandscapeMapper landscapeMapper;


    @Override
    public void createViewRecord(Landscape landscape,User user) {
        Long creator = user.getAccountid();
        if (null != creator) {
            landscape.setCreator(creator);
        }
        //默认的图片
        String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587543007161&di=c2f9fd0050132054125776cdadd92e93&imgtype=0&src=http%3A%2F%2Fwww.17qq.com%2Fimg_qqtouxiang%2F88015074.jpeg";
        landscape.setImgUrl(imgUrl);
        landscape.setViewCount(0L);
        landscape.setCommentCount(0L);
        landscape.setScore(0.0);
        Long currentTime = System.currentTimeMillis();
        landscape.setCtime(currentTime);
        landscape.setUtime(currentTime);
        int insert = landscapeMapper.insert(landscape);
        //当返回值不等于1时，表示没有插入成功
        if (insert != 1) {
            throw new CustomizeException(CustomizeErrorEnums.VIEW_CREATE_IS_FAIL);
        }
    }
}
