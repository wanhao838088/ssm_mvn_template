package com.wanhao.ssm.controller.user;

import com.github.pagehelper.PageInfo;
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
    public JsonArrayResult<User> index(String start,String end,
                                       String username,Integer page){
        User user = new User();
        user.setUsername(username);
        user.setPage(page);

        List<User> users = userService.findUser(user);
        //创建分页对象 用来获取总记录数
        PageInfo<User> info = new PageInfo<>(users);

        return new JsonArrayResult<>(0,users,(int)info.getTotal());
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
