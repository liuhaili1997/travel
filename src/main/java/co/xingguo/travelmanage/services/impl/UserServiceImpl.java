package co.xingguo.travelmanage.services.impl;

import co.xingguo.travelmanage.dto.UserDto;
import co.xingguo.travelmanage.enums.impl.CustomizeErrorEnums;
import co.xingguo.travelmanage.exception.CustomizeException;
import co.xingguo.travelmanage.mapper.UserMapper;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.model.UserExample;
import co.xingguo.travelmanage.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 实现接口隔离
 * @author Created by hailitortoise on 2020-04-18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public void createOrUpdateUser(User user) {
        //每一个账号对应一个email 不能用accountId，因为一开始没生成
        String email1 = user.getEmail();
        String name = user.getName();
        UserExample userExample = new UserExample();
        //保障用户名统一
        userExample.createCriteria()
                .andEmailEqualTo(email1)
                .andNameEqualTo(name);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            //创建用户记录
            //todo 做用户信息修改可以自己上传图片 默认图片信息
            user.setAvatarUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1666256797,972082711&fm=26&gp=0.jpg");
            // 根据时间生成唯一的id
            Long stamp = System.currentTimeMillis() / 1000;
            String stampstr = stamp.toString();
            /**
             * Long.ValueOf("String")返回Long包装类型
             * Long.parseLong("String")返回long基本数据类型
             */
            Long accountId =Long.valueOf(stampstr.substring(1, stampstr.length()));
            user.setAccountid(accountId);
            user.setCtime(System.currentTimeMillis());
            user.setUtime(user.getCtime());
            userMapper.insert(user);
        } else {
           /* User dbUser = new User();
            //没人只有一次机会修改用户名，就是创建的时候 类似微信号
            String name = user.getName();
            if (StringUtils.isNotBlank(name)) {
                dbUser.setName(name);
            }
            User userForDb = userList.get(0);
            BeanUtils.copyProperties(userForDb,dbUser);
            String password = user.getPassword();
            if (StringUtils.isNotBlank(password)) {
                dbUser.setPassword(password);
            }
            String phone = user.getPhone();
            if (StringUtils.isNotBlank(phone)) {
                dbUser.setPhone(phone);
            }
            String email = user.getEmail();
            if (StringUtils.isNotBlank(email)) {
                dbUser.setEmail(email);
            }
            String avatarUrl = user.getAvatarUrl();
            if (StringUtils.isNotBlank(avatarUrl)) {
                dbUser.setAvatarUrl(avatarUrl);
            }
            //type 不可以修改，后买你优化一下，添加一个创建的管理者登录窗口
            dbUser.setToken(user.getToken());
            dbUser.setUtime(System.currentTimeMillis());
            userMapper.updateByPrimaryKey(dbUser);*/
            throw new CustomizeException(CustomizeErrorEnums.USER_RECORD_IS_EXIT);
        }
    }

    @Override
    public void updateUserInfo(UserDto userDto) {
        User user = userMapper.selectByPrimaryKey(userDto.getId());
        if (user == null) {
            throw new CustomizeException(CustomizeErrorEnums.USER_IS_NOT_EXIT);
        }
        String avatar = userDto.getAvatarUrl();
        if (StringUtils.isNotBlank(avatar)) {
            user.setAvatarUrl(avatar);
        }
        String name = userDto.getName();
        if (StringUtils.isNotBlank(name)) {
            user.setName(name);
        }
        String phone = userDto.getPhone();
        if (StringUtils.isNotBlank(phone)) {
            user.setPhone(phone);
        }
        String password = userDto.getPassword();
        if (StringUtils.isNotBlank(password)) {
            user.setPassword(password);
        }
        Long currentTime = System.currentTimeMillis();
        user.setUtime(currentTime);
        int i = userMapper.updateByPrimaryKey(user);
        if (i != 1) {
            throw new CustomizeException(CustomizeErrorEnums.USER_UPDATE_IS_FAIL);
        }
    }
}
