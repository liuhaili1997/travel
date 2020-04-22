package co.xingguo.travelmanage.controller;

import co.xingguo.travelmanage.model.Hotel;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.services.HotelService;
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
 * @author Created by hailitortoise on 2020-04-22
 */
@Controller
public class PublishController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private HotelService hotelService;


    /**
     * 一个页面多级目录显示
     *
     * @param action  操作
     * @param model   model
     * @param request 请求
     * @return 返回页面
     */
    @GetMapping("/publish/{action}")
    public String publish(@PathVariable(name = "action") String action, Model model, HttpServletRequest request) {
        //获取session内部的user，判断是否存在，才有权限
        User user = (User) request.getSession().getAttribute("user");
        if (null == user) {
            return "redirect:/";
        }
        //显示相关的页面，对数据进行发布的是点击下面的连接
        if ("guesthost".equals(action)) {
            model.addAttribute("section", "guesthost");
            model.addAttribute("sectionName", "酒店");
        } else if ("specialfood".equals(action)) {
            model.addAttribute("section", "specialfood");
            model.addAttribute("sectionName", "著名菜系");
        } else if ("refreshments".equals(action)) {
            model.addAttribute("section", "refreshments");
            model.addAttribute("sectionName", "特色小吃");
        } else if ("history".equals(action)) {
            model.addAttribute("section", "history");
            model.addAttribute("sectionName", "相关历史");
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
     * @param request     请求
     * @param model       与前端交互
     */
    @PostMapping("/publish/landscape")
    public String publishView(@RequestParam(name = "viewTitle", required = false) String title,
                            @RequestParam(name = "openTime", required = false) String openTime,
                            @RequestParam(name = "address", required = false) String address,
                            @RequestParam(name = "price", required = false) BigDecimal price,
                            @RequestParam(name = "viewTitle", required = false) String description,
                            @RequestParam(name = "tag", required = false) String tag,
                            HttpServletRequest request, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        /*回显*/
        model.addAttribute("viewTitle", title);
        model.addAttribute("openTime", openTime);
        model.addAttribute("address", address);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
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
        viewService.createViewRecord(landscape, user);
        return "redirect:/";
    }

    /**
     * 新增酒店记录
     *
     * @param name       标题
     * @param address     地址
     * @param price       价格
     * @param description 描述
     * @param tag         tag
     * @param request     请求
     * @param model       与前端交互
     */
    @PostMapping("/publish/guesthost")
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
        //必须要加这个，不然不好刷新界面啊
        model.addAttribute("section", "guesthost");
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
        if (StringUtils.isBlank(tag)) {
            model.addAttribute("hotelError", "只要要选一个tag，来标注景区的特色！！");
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
}
