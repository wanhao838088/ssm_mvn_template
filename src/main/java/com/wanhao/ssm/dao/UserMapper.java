package com.wanhao.ssm.dao;

import com.wanhao.ssm.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {


}
