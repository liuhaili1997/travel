package co.xingguo.travelmanage.services.impl;

import co.xingguo.travelmanage.dto.PageInformationDto;
import co.xingguo.travelmanage.dto.QuestionQueryDto;
import co.xingguo.travelmanage.dto.ViewDto;
import co.xingguo.travelmanage.enums.impl.CustomizeErrorEnums;
import co.xingguo.travelmanage.exception.CustomizeException;
import co.xingguo.travelmanage.mapper.LandscapeMapper;
import co.xingguo.travelmanage.mapper.UserMapper;
import co.xingguo.travelmanage.mapper.ViewExtendMapper;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.LandscapeExample;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.model.UserExample;
import co.xingguo.travelmanage.services.ViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实现类
 * @author Created by hailitortoise on 2020-04-22
 */
@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    private LandscapeMapper landscapeMapper;

    @Autowired
    private ViewExtendMapper viewExtendMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public void createOrUpdateRecord(Landscape landscape, User user) {
        Long currentTime = System.currentTimeMillis();
        Long id = landscape.getId();
        Long creator = user.getAccountid();
        if (null != creator) {
            landscape.setCreator(creator);
        }
        if ( id == null) {
            //默认的图片
            String imgUrl = "http://gtd.alicdn.com/bao/uploaded///img.alicdn.com/bao/uploaded/tfscom/TB1RHvaTbvpK1RjSZPiSuvmwXXa_600x600.jpg";
            landscape.setImgUrl(imgUrl);
            landscape.setViewCount(0L);
            landscape.setCommentCount(0L);
            landscape.setScore(0.0);
            landscape.setCtime(currentTime);
            landscape.setUtime(currentTime);
            int insert = landscapeMapper.insert(landscape);
            //当返回值不等于1时，表示没有插入成功
            if (insert != 1) {
                throw new CustomizeException(CustomizeErrorEnums.VIEW_CREATE_IS_FAIL);
            }
        } else {
            //todo 我知道自己不会去做，所以先标注一下：这里其实可以优化景区的图片和评分，可以后期加上
            Landscape primaryKey = landscapeMapper.selectByPrimaryKey(id);
            //执行更新操作
            String title = landscape.getTitle();
            if (StringUtils.isNotBlank(title)) {
                primaryKey.setTitle(title);
            }
            String openTime = landscape.getOpenTime();
            if (StringUtils.isNotBlank(openTime)) {
                primaryKey.setOpenTime(openTime);
            }
            String address = landscape.getAddress();
            if (StringUtils.isNotBlank(address)) {
                primaryKey.setAddress(address);
            }
            BigDecimal price = landscape.getPrice();
            if (null != price) {
                primaryKey.setPrice(price);
            }
            String tag = landscape.getTag();
            if (StringUtils.isNotBlank(tag)) {
                primaryKey.setTag(tag);
            }
            String description = landscape.getDescription();
            if (StringUtils.isNotBlank(description)) {
                primaryKey.setDescription(description);
            }
            primaryKey.setUtime(currentTime);
            LandscapeExample landscapeExample = new LandscapeExample();
            landscapeExample.createCriteria()
                    .andIdEqualTo(id);
            int updateByExample = landscapeMapper.updateByPrimaryKeySelective(primaryKey);
            if (updateByExample != 1) {
                throw new CustomizeException(CustomizeErrorEnums.VIEW_UPDATE_IS_FAIL);
            }
        }
    }

    @Override
    public PageInformationDto list(Integer currentPage, Integer pageSize, String search, String tag) {

        PageInformationDto<ViewDto> pageInformationDto = new PageInformationDto<>();

        //搜索采用的是正则表达式
        //搜索实现
        if (StringUtils.isNotBlank(search)) {
            String[] searchs = StringUtils.split(search, " ");
            search = Arrays.stream(searchs).collect(Collectors.joining("|"));
            //replace:   search = String.join("|", searchs);
        }
        QuestionQueryDto questionQueryDto = new QuestionQueryDto();
        if (StringUtils.isNotBlank(search)) {
            questionQueryDto.setSearch(search);
        }
        if (StringUtils.isNotBlank(tag)) {
            questionQueryDto.setTag(tag);
        }
        //根据查询获取具体的数量进行分页
        Integer total = viewExtendMapper.countByExample(questionQueryDto);

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

        /*LandscapeExample example = new LandscapeExample();
        example.setOrderByClause("ctime desc");
        List<Landscape> landscapes = landscapeMapper.selectByExampleWithBLOBsWithRowbounds(example, new RowBounds(offSize, pageSize));*/

        //search 对应新的搜索查询
        questionQueryDto.setCurrantPage(offSize);
        questionQueryDto.setPageSize(pageSize);
        List<Landscape> landscapes = viewExtendMapper.selectBySearch(questionQueryDto);

        if (CollectionUtils.isEmpty(landscapes)) {
            return new PageInformationDto<>();
        }
        //根据creator来来获取用户信息 在这里显示的主页是没有用的 最简单的，最直接的，也是是最有效的途径
        List<Long> creatorList = landscapes.stream().map(Landscape::getCreator).collect(Collectors.toList());
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountidIn(creatorList);
        List<User> userList = userMapper.selectByExample(userExample);
        //集合转为map 在遍历数组时就是n 而不是n*n
        Map<Long, User> userMap = userList.stream()
                .collect(Collectors.toMap(User::getAccountid, user -> user, (oldValue, newValue) -> newValue));
        //做聚合数据，这里可以单独提出来，作为一个方法
        ViewDto viewDto;
        List<ViewDto> data = new ArrayList<>();
        for (Landscape landscape : landscapes) {
            viewDto = new ViewDto();
            BeanUtils.copyProperties(landscape, viewDto);
            User user = userMap.get(landscape.getCreator());
            if (null != user) {
                viewDto.setUser(user);
            }
            data.add(viewDto);
        }
        pageInformationDto.setData(data);
        return pageInformationDto;
    }

    @Override
    public ViewDto getById(Long id) {
        ViewDto viewDto = new ViewDto();
        //根据id查询对应的记录
        Landscape landscape = landscapeMapper.selectByPrimaryKey(id);
        if (landscape == null) {
            throw new CustomizeException(CustomizeErrorEnums.VIEW_FIND_IS_NOT_EXIT);
        }
        BeanUtils.copyProperties(landscape, viewDto);
        UserExample example = new UserExample();
        example.createCriteria()
                .andAccountidEqualTo(landscape.getCreator());
        /*一个accountId对应的是唯一一个用户，只是存在或者不存在而已*/
        List<User> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)) {
            viewDto.setUser(users.get(0));
        }
        return viewDto;
    }

    @Override
    public List<ViewDto> selectRelated(ViewDto viewDto) {
        //对tag进行操作，把对应的tag的“，”替换成“|”用于正则查询
        String tag = viewDto.getTag();
        if (StringUtils.isBlank(tag)) {
            return new ArrayList<>();
        }
        String[] split = StringUtils.split(tag, ",");
        String splitTag = Arrays.stream(split).collect(Collectors.joining("|"));
        //展示除了本例以外的其他相关主题tag
        Landscape landscape = new Landscape();
        landscape.setId(viewDto.getId());
        landscape.setTag(splitTag);
        List<Landscape> landscapes = viewExtendMapper.selectRelated(landscape);
        List<ViewDto> viewDtos = landscapes.stream().map(p -> {
            ViewDto view = new ViewDto();
            BeanUtils.copyProperties(p, view);
            return view;
        }).collect(Collectors.toList());
        return viewDtos;
    }

    @Override
    public void incViewCount(Long id) {
        if (null == id) {
            return;
        }
        Landscape landscape = new Landscape();
        landscape.setId(id);
        landscape.setViewCount(1L);
        viewExtendMapper.incViewCount(landscape);
    }

    @Override
    public void incCommentCount(Long id) {
        if (null == id) {
            return;
        }
        Landscape landscape = new Landscape();
        landscape.setId(id);
        landscape.setCommentCount(1L);
        viewExtendMapper.incCommentCount(landscape);
    }
}
