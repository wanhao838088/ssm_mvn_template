package com.wanhao.ssm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 用来登录的用户
 * Created by LiuLiHao on 2017/1/15.
 */
@Table(name = "ssm_user")
@Setter
@Getter
@ToString
public class User implements Serializable {
    @Id
    @Column(name = "id")
    //@GeneratedValue(generator ="IDENTITY")
    private Integer id;
    private String username;
    private String mobile;
    private String password;
    private String login_token;

    private String head_img_url;
    /**
     * 注册时间
     */
    private Date register_time;
    /**
     * 登录时间
     */
    private Date login_time;
    private Integer is_delete;

}
