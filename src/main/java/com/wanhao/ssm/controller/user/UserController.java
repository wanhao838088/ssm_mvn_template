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

    @RequestMapping(value = "index")
    @ResponseBody
    public JsonArrayResult<User> index(){
        List<User> users = userService.selectAll();
        return new JsonArrayResult<>(0,users);
    }

}
