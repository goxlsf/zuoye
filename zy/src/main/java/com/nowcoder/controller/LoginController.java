package com.nowcoder.controller;

import com.nowcoder.model.HostHolder;
import com.nowcoder.model.ViewObject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.AdminService;
import com.nowcoder.service.UserService;
import com.nowcoder.service.VoteService;
import com.nowcoder.util.ToutiaoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @RequestMapping(path = {"/reg/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "rember",defaultValue = "0") int remeberme,@RequestParam(value = "admin",defaultValue = "0") int isadmin, HttpServletResponse response) {
        if(isadmin>0)
        {
            try {
                Map<String,Object> map = adminService.register(username,password);
                if(map.containsKey("ticket")){
                    Cookie cookie = new Cookie("ticket",map.get("ticket").toString());
                    cookie.setPath("/");
                    if (remeberme>0)
                    {
                        cookie.setMaxAge(3600*24*7);
                    }
                    response.addCookie(cookie);
                    model.addAttribute("admin",username);
                    return ToutiaoUtil.getJSONString(0,"注册成功");

                }
                else {
                    return ToutiaoUtil.getJSONString(1, map);
                }
            }
            catch (Exception e){
                logger.error("注册异常"+e.getMessage());
                return ToutiaoUtil.getJSONString(1,"注册异常");
            }
        }
        else {
            try {
                Map<String, Object> map = userService.register(username, password);
                if (map.containsKey("ticket")) {
                    Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                    cookie.setPath("/");
                    if (remeberme > 0) {
                        cookie.setMaxAge(3600 * 24 * 7);
                    }
                    response.addCookie(cookie);
                    model.addAttribute("user",username);
                    return ToutiaoUtil.getJSONString(0, "注册成功");
                } else {
                    return ToutiaoUtil.getJSONString(1, map);
                }
            } catch (Exception e) {
                logger.error("注册异常" + e.getMessage());
                return ToutiaoUtil.getJSONString(1, "注册异常");
            }
        }
    }
    @RequestMapping(path = {"/login/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String login(Model model, @RequestParam("username") String username,@RequestParam("password") String password,@RequestParam(value = "rember",defaultValue = "0") int remeberme,@RequestParam(value = "admin",defaultValue = "0") int isadmin,HttpServletResponse response) {
        if (isadmin > 0) {
            try {
                Map<String, Object> map = adminService.adminLogin(username, password);
                if (map.containsKey("ticket")) {
                    Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                    cookie.setPath("/");
                    if (remeberme > 0) {
                        cookie.setMaxAge(3600 * 24 * 7);
                    }
                    response.addCookie(cookie);
                    model.addAttribute("admin", username);
                    return ToutiaoUtil.getJSONString(0, "登陆成功");

                } else {
                    return ToutiaoUtil.getJSONString(1, map);
                }
            } catch (Exception e) {
                logger.error("登陆异常" + e.getMessage());
                return ToutiaoUtil.getJSONString(1, "登陆异常");
            }
        } else {
            try {
                Map<String, Object> map = userService.login(username, password);
                if (map.containsKey("ticket")) {
                    Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                    cookie.setPath("/");
                    if (remeberme > 0) {
                        cookie.setMaxAge(3600 * 24 * 7);
                    }
                    response.addCookie(cookie);
                    return ToutiaoUtil.getJSONString(0, "登陆成功");
                } else {
                    return ToutiaoUtil.getJSONString(1, map);
                }
            } catch (Exception e) {
                logger.error("登陆异常" + e.getMessage());
                return ToutiaoUtil.getJSONString(1, "登陆异常");
            }

        }
    }
    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(Model model, @RequestParam(value = "admin",defaultValue = "0")String admin, HttpServletResponse response, HttpServletRequest request){
        HostHolder hostHolder = new HostHolder();
        hostHolder.clear();
        Cookie cookie = new Cookie("ticket",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(admin.equals("admin"))
        return "redirect:/admin";
        else
            return "redirect:/";

    }

}
