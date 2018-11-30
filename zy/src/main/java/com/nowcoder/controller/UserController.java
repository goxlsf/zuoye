package com.nowcoder.controller;

import com.nowcoder.model.HostHolder;
import com.nowcoder.model.User;
import com.nowcoder.model.ViewObject;
import com.nowcoder.model.Voteoption;
import com.nowcoder.service.UserService;
import com.nowcoder.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = {"/user"}, method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    private List<ViewObject> getNews(int questionId) {
        List<Voteoption> userList = voteService.getLatestNews(questionId);

        List<ViewObject> vos = new ArrayList<>();
        for (Voteoption votes : userList) {
            ViewObject vo = new ViewObject();
            vo.set("votes", votes);
            vos.add(vo);
        }
        return vos;
    }


    @RequestMapping(path = {"/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model, @RequestParam(value = "pop", defaultValue = "0") int pop) {

        return "adminUser";
    }
    @RequestMapping(path = {"/sub"}, method = {RequestMethod.GET, RequestMethod.POST})
    public void modSub(Model model, @RequestParam(value = "username") String userName,@RequestParam(value = "password") String password,@RequestParam(value = "userId") int userId) {
        User user = new User();
        user.setId(userId);
        user.setPassWord(password);
        user.setUserName(userName);
        userService.updateByuserId(user);

    }
    @RequestMapping(path = {"/mod"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mod(@RequestParam(value = "userId") int userId) {
        User user = userService.getUser(userId);
        ModelAndView mv = new ModelAndView("userMod");
        mv.addObject("user",user);
        mv.addObject("userId",userId);
        return mv;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void deleteUser(@RequestParam("userId") int userId){
        userService.deleteByuserId(userId);
    }
    @RequestMapping("/index")
    @ResponseBody
    public List<User> getUserListPage(String userName, HttpServletRequest request) {

        List<User> list = userService.getLatestUsers(userName);

        return list;
    }
}
