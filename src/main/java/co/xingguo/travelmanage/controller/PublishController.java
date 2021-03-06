package co.xingguo.travelmanage.controller;

import co.xingguo.travelmanage.cache.TagCache;
import co.xingguo.travelmanage.dto.PageInformationDto;
import co.xingguo.travelmanage.dto.ViewDto;
import co.xingguo.travelmanage.model.Hotel;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.services.HotelService;
import co.xingguo.travelmanage.services.ReservationService;
import co.xingguo.travelmanage.services.ViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * 发布信息
 *
 * @author Created by hailitortoise on 2020-04-22
 */
@Controller
public class PublishController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ReservationService reservationService;


    /**
     * 一个页面多级目录显示
     *
     * @param action  操作
     * @param model   model
     * @param request 请求
     * @return 返回页面
     */
    @GetMapping("/publish/{action}")
    public String publish(@PathVariable(name = "action") String action, Model model, HttpServletRequest request,
                          @RequestParam(name = "search", required = false) String search,
                          @RequestParam(name = "page", defaultValue = "1") Integer currentPage,
                          @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        //获取session内部的user，判断是否存在，才有权限
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            return "redirect:/";
        }
        model.addAttribute("tags", TagCache.get());
        //显示相关的页面，对数据进行发布的是点击下面的连接
        if ("guesthouse".equals(action)) {
            model.addAttribute("section", "guesthouse");
            model.addAttribute("sectionName", "酒店");
        } else if ("specialfood".equals(action)) {
            model.addAttribute("section", "specialfood");
            model.addAttribute("sectionName", "著名菜系");
        } else if ("refreshments".equals(action)) {
            model.addAttribute("section", "refreshments");
            model.addAttribute("sectionName", "特色小吃");
        } else if ("appointmentRecord".equals(action)) {
            model.addAttribute("section", "appointmentRecord");
            model.addAttribute("sectionName", "预约记录");
            PageInformationDto pageInformationDto = reservationService.list(currentPage, pageSize, search);
            model.addAttribute("reservation", pageInformationDto);
            model.addAttribute("search", search);
        } else {
            model.addAttribute("section", "landscape");
            model.addAttribute("sectionName", "景区");
        }
        return "publish";
    }


    /**
     * 新增景点记录
     *
     * @param title       标题
     * @param openTime    开放时间
     * @param address     地址
     * @param price       价格
     * @param description 描述
     * @param tag         tag
     * @param id
     * @param request     请求
     * @param model       与前端交互
     */
    @PostMapping("/publish/landscape")
    public String publishView(@RequestParam(name = "viewTitle", required = false) String title,
                              @RequestParam(name = "openTime", required = false) String openTime,
                              @RequestParam(name = "address", required = false) String address,
                              @RequestParam(name = "price", required = false) BigDecimal price,
                              @RequestParam(name = "description", required = false) String description,
                              @RequestParam(name = "tag", required = false) String tag,
                              @RequestParam(name = "id", required = false) Long id,
                              HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        /*回显*/
        model.addAttribute("viewTitle", title);
        model.addAttribute("openTime", openTime);
        model.addAttribute("address", address);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        model.addAttribute("id", id);
        model.addAttribute("tags", TagCache.get());
        //必须要加这个，不然不好刷新界面啊
        model.addAttribute("section", "landscape");
        //后端判断不在前端进行判断
        if (StringUtils.isBlank(title)) {
            model.addAttribute("viewError", "您未添加景区名称，不符合规范哦！！");
            return "publish";
        }
        if (StringUtils.isBlank(openTime)) {
            model.addAttribute("viewError", "您未添加营业时间，不符合规范哦！！");
            return "publish";
        }
        if (StringUtils.isBlank(address)) {
            model.addAttribute("viewError", "请添加详细地址，方便游客导航！！");
            return "publish";
        }
        if (StringUtils.isBlank(description)) {
            model.addAttribute("viewError", "您未添加描述信息，不符合规范哦！！");
            return "publish";
        }
        if (StringUtils.isBlank(tag)) {
            model.addAttribute("viewError", "只要要选一个tag，来标注景区的特色！！");
            return "publish";
        }
        //进行数据操作
        Landscape landscape = new Landscape();
        landscape.setTitle(title);
        landscape.setOpenTime(openTime);
        landscape.setAddress(address);
        landscape.setPrice(price);
        landscape.setTag(tag);
        landscape.setDescription(description);
        //service 判断是否存在id 来确定是否更新还是新插入一条数据
        if (null != id) {
            landscape.setId(id);
        }
        viewService.createOrUpdateRecord(landscape, user);
        return "redirect:/";
    }

    /**
     * 新增酒店记录
     * todo 现在没有实现的时间，可以留着在后面优化添加
     *
     * @param name        标题
     * @param address     地址
     * @param price       价格
     * @param description 描述
     * @param tag         tag
     * @param request     请求
     * @param model       与前端交互
     */
    @PostMapping("/publish/guesthouse")
    public String publishHotel(@RequestParam(name = "hotelName", required = false) String name,
                               @RequestParam(name = "hotelAddress", required = false) String address,
                               @RequestParam(name = "hotelPrice", required = false) BigDecimal price,
                               @RequestParam(name = "hotelDescription", required = false) String description,
                               @RequestParam(name = "hotelTag", required = false) String tag,
                               HttpServletRequest request, Model model) {
        User users = (User) request.getSession().getAttribute("user");
        /*回显*/
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", TagCache.get());
        //必须要加这个，不然不好刷新界面啊
        model.addAttribute("section", "guesthouse");
        //后端判断不在前端进行判断
        if (StringUtils.isBlank(name)) {
            model.addAttribute("hotelError", "您未添加酒店名称，不符合规范哦！！");
            return "publish";
        }
        if (StringUtils.isBlank(address)) {
            model.addAttribute("hotelError", "请添加详细地址，方便游客导航！！");
            return "publish";
        }
        if (StringUtils.isBlank(description)) {
            model.addAttribute("hotelError", "您未添加描述信息，不符合规范哦！！");
            return "publish";
        }
        String inValid = TagCache.filterInValid(tag);
        if (StringUtils.isNotBlank(inValid)) {
            model.addAttribute("erro", "你自己写了的标签是不能存的哦！！非法标签：" + inValid);
            return "publish";
        }
        //进行数据操作
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setPrice(price);
        hotel.setDescription(description);
        hotel.setTag(tag);
        hotelService.createHotelRecord(hotel, users);
        return "redirect:/";
    }

    @GetMapping("/publish/landscape/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        ViewDto viewDto = viewService.getById(id);
        /*回显*/
        model.addAttribute("id", viewDto.getId());
        model.addAttribute("viewTitle", viewDto.getTitle());
        model.addAttribute("openTime", viewDto.getOpenTime());
        model.addAttribute("address", viewDto.getAddress());
        model.addAttribute("price", viewDto.getPrice());
        model.addAttribute("description", viewDto.getDescription());
        model.addAttribute("tag", viewDto.getTag());
        model.addAttribute("tags", TagCache.get());
        //必须要加这个，不然不好刷新界面啊
        model.addAttribute("section", "landscape");


        return "publish";
    }

}
