package com.wanhao.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.wanhao.ssm.dao.UserMapper;
import com.wanhao.ssm.entity.User;
import com.wanhao.ssm.service.UserService;
import com.wanhao.ssm.utils.IsNullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by LiuLiHao on 2018/9/1 11:25.
 * 描述：
 * 作者： LiuLiHao
 */
@Service
@Transactional
public class UserServiceImpl extends BaseService<User>  implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<User> findUser(User user) {
        if (user.getPage() != null && user.getPage()>0 && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        Example example = new Example(user.getClass());
        Example.Criteria criteria = example.createCriteria();
        //会员姓名
        if (IsNullUtils.isNotNull(user.getUsername())){
            criteria.andLike("username","%"+user.getUsername()+"%");
        }

        return userMapper.selectByExample(example);
    }
}
