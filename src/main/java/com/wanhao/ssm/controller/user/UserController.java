package com.wanhao.ssm.controller.user;

import com.wanhao.ssm.entity.User;
import com.wanhao.ssm.entity.util.JsonArrayResult;
import com.wanhao.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LiuLiHao on 2018/9/1 11:28.
 * 描述： 用户
 * 作者： LiuLiHao
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final String PREFIX = "user/";

    @RequestMapping(value = "listData")
    @ResponseBody
    public JsonArrayResult<User> index(){
        List<User> users = userService.selectAll();
        return new JsonArrayResult<>(0,users);
    }

    /**
     * 用户列表页面跳转
     * @return
     */
    @RequestMapping(value = "listHtml")
    public String listHtml(){
        return PREFIX+"list";
    }

}
