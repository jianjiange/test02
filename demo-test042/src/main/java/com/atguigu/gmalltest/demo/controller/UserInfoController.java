package com.atguigu.gmalltest.demo.controller;

import com.atguigu.gmalltest.demo.bean.UserInfo;
import com.atguigu.gmalltest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserService userService;


    @RequestMapping("findAll")
    @ResponseBody //返回json
    public List<UserInfo> findAll() {

        return userService.findAll();
    }
    @RequestMapping("findByUserInfo")
    @ResponseBody //返回json
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {

        return userService.findByUserInfo(userInfo);
    }

    @RequestMapping("findByLoginName")
    @ResponseBody //返回json
    public List<UserInfo> findByLoginName(UserInfo userInfo) {

        return userService.findByLoginName(userInfo.getLoginName());
    }


    @RequestMapping("addUser")
    @ResponseBody //返回json
    public void addUser(UserInfo userInfo) {
            userInfo.setLoginName("111");
            userInfo.setName("2222");
            userInfo.setPasswd("3333");
        userService.addUser(userInfo);
    }

    @RequestMapping("updUser")
    @ResponseBody //返回json
    public void updUser(UserInfo userInfo) {
        userService.updUser(userInfo);
    }

    @RequestMapping("delUser")
    @ResponseBody //返回json
    public void delUser(UserInfo userInfo) {
        userService.delUser(userInfo);
    }
}
