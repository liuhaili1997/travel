package co.xingguo.travelmanage.controller;

import co.xingguo.travelmanage.enums.UserTypeEnums;
import co.xingguo.travelmanage.mapper.UserMapper;
import co.xingguo.travelmanage.model.User;
import co.xingguo.travelmanage.model.UserExample;
import co.xingguo.travelmanage.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Created by hailitortoise on 2020-04-17
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/login")
    public String toLoginHtml() {
        return "login";
    }

    /**
     * 这个是一个比较奇怪的界面 它是一个弹窗，可以post请求，但是不能get请求到这个界面
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam(name = "name",required = false) String name,
                        @RequestParam(name = "password", required = false) String password,
                        HttpServletResponse response,Model model) {
        model.addAttribute("userName", name);
        if (StringUtils.isBlank(name)) {
            model.addAttribute("loginError", "用户名没写，不让你进入！！");
            return "login";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("loginError", "密码都没有，你想干嘛！！好好在首页呆着");
            return "login";
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            model.addAttribute("loginError", "用户不存在啊，好好的去注册一下吧");
            return "login";
        }
        User user = users.get(0);
        if (user.getPassword().equals(password)) {
            response.addCookie(new Cookie("token", user.getToken()));
            return "redirect:/";
        } else {
            model.addAttribute("loginError", "密码错误了哦，你要再想一下呀");
            return "login";
        }
    }

    /**
     * 当其他页面点击连接，可以通过这个来跳转界面
     * @param model model
     * @return 页面
     */
    @GetMapping("/register")
    public String toRegisterHtml(Model model) {
        return "register";
    }

    /**
     * 注册用户信息
     * @param name 姓名
     * @param password 密码
     * @param phone 电话
     * @param email 邮箱
     * @param avatarUrl 头像
     * @param request 请求
     * @param model model
     * @return 返回页面
     */
    @PostMapping("/register")
    public String register(@RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "password", required = false) String password,
                           @RequestParam(name = "phone", required = false) String phone,
                           @RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "avatarUrl", required = false) String avatarUrl,
                           HttpServletRequest request, Model model) {
        //回显前端
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        if (StringUtils.isBlank(name)) {
            model.addAttribute("registerError", "你还没填名字呢！！填一下吧");
            return "register";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("registerError", "密码！密码！密码！重要的事情说三遍，你还没写");
            return "register";
        }
        if (StringUtils.isBlank(email)) {
            model.addAttribute("registerError", "能方便写一下您的邮箱吗？方便你后面找回密码");
            return "register";
        }
        //生成token
        String token = UUID.randomUUID().toString();

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        if (StringUtils.isNotBlank(phone)) {
            user.setPhone(phone);
        }
        user.setToken(token);
        user.setType(UserTypeEnums.ORDINARY_PEOPLE.getCode());
        //默认图片信息
        //todo 编辑用户信息时用户才可以自己上传图片
        userService.createOrUpdateUser(user);
        return "index";
    }


    /**
     * 退出登录，就必须要清除token cookie session
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logOut(HttpServletRequest request,
                         HttpServletResponse response) {
        //清除session
        request.getSession().removeAttribute("user");
        //清除已知的cookie 建立一个重名的cookie，key对应的value赋值为null 设置MaxAge为0
        Cookie cookie = new Cookie("token", null);
        //立即删除型
        cookie.setMaxAge(0);
        //项目的所有目录均有效
        cookie.setPath("/");
        //重新写入将覆盖之前的cookie
        response.addCookie(cookie);
        return "redirect:/";
    }
}
