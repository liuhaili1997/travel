package co.xingguo.travelmanage.controller;

import co.xingguo.travelmanage.dto.PageInformationDto;
import co.xingguo.travelmanage.dto.ViewDto;
import co.xingguo.travelmanage.enums.impl.CustomizeErrorEnums;
import co.xingguo.travelmanage.exception.CustomizeException;
import co.xingguo.travelmanage.mapper.LandscapeMapper;
import co.xingguo.travelmanage.mapper.UserMapper;
import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.model.UserExample;
import co.xingguo.travelmanage.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Created by hailitortoise on 2020-04-17
 */
@Controller
public class IndexController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private LandscapeMapper landscapeMapper;


    @GetMapping("/")
    public String index(@RequestParam(name = "page", defaultValue = "1") Integer currentPage,
                        @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize,
                        @RequestParam(name = "search", required = false) String search,
                        HttpServletRequest request, Model model) {

        PageInformationDto pageInformationDto = viewService.list(currentPage, pageSize, search,null);
        model.addAttribute("viewInfo", pageInformationDto);
        //用于回显数据
        model.addAttribute("search", search);

        return "index";
    }

    @GetMapping("/view/{id}")
    public String viewDisplay(@PathVariable(name = "id") Long id, Model model) {
        //根据id查询相关信息
        ViewDto viewDto = viewService.getById(id);
        // 根据tag查询相关的tag的景点
        List<ViewDto> viewDtos = viewService.selectRelated(viewDto);
        //增加阅读数
        viewService.incViewCount(id);
        model.addAttribute("view", viewDto);
        model.addAttribute("user", viewDto.getUser());
        model.addAttribute("relationView", viewDtos);
        return "view";

    }

    @GetMapping("/view/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        int delete = landscapeMapper.deleteByPrimaryKey(id);
        if (delete != 1) {
            throw new CustomizeException(CustomizeErrorEnums.VIEW_DELETE_IS_FAIL);
        }
        return "redirect:/";
    }

    /*以下将用于展示各个区的景区信息*/

    /**
     * 展示省内景点
     *
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @param search 搜索条件
     * @param model model
     * @return 返回指定页面
     */
    @GetMapping("/viewName/{action}")
    public String displayProvince(@RequestParam(name = "page", defaultValue = "1") Integer currentPage,
                                  @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize,
                                  @RequestParam(name = "search", required = false) String search,
                                  Model model, @PathVariable(name = "action") String action) {
        if ("province".equals(action)) {
            PageInformationDto pageInformationDto = viewService.list(currentPage, pageSize, search,"省内");
            model.addAttribute("viewInfo", pageInformationDto);
            model.addAttribute("search", search);
            model.addAttribute("tag", "省内景点");
        } else if ("domestic".equals(action)) {
            PageInformationDto pageInformationDto = viewService.list(currentPage, pageSize, search,"国内");
            model.addAttribute("viewInfo", pageInformationDto);
            model.addAttribute("search", search);
            model.addAttribute("tag", "国内景点");
        } else if ("abroad".equals(action)) {
            PageInformationDto pageInformationDto = viewService.list(currentPage, pageSize, search,"海外");
            model.addAttribute("viewInfo", pageInformationDto);
            model.addAttribute("search", search);
            model.addAttribute("tag", "海外景点");
        }
        return "province";
    }
}
