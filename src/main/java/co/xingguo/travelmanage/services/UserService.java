package co.xingguo.travelmanage.services;

import co.xingguo.travelmanage.dto.UserDto;
import co.xingguo.travelmanage.model.User;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 更新用户信息
     *
     * @param userDto 拓展类
     * @param file 图片
     */
    void updateUserInfo(UserDto userDto, MultipartFile file);
}
