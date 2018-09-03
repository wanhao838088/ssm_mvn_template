package com.wanhao.ssm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LiuLiHao on 2018/7/16 11:25.
 * 描述： 对象基础信息
 * 作者： LiuLiHao
 */
@Setter
@Getter
@ToString
public class BaseBean implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 10;
}
