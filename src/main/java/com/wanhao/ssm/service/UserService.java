package com.wanhao.ssm.service;

import com.wanhao.ssm.entity.User;

import java.util.List;

/**
 * Created by LiuLiHao on 2018/9/1 11:25.
 * 描述：
 * 作者： LiuLiHao
 */
public interface UserService extends IService<User>{

    List<User> findUser(User user);

}
