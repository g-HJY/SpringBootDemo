package com.example.demo.entity.test;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户表(TCustomer)实体类
 *
 * @author makejava
 * @since 2021-10-09 10:48:23
 */

@Getter
@Setter
public class Customer implements Serializable {
    private static final long serialVersionUID = -23726225018826148L;
    /**
     * 主键
     */
    private String fcustomerid;
    /**
     * 部门id
     */
    private Long fdepartmentid;
    /**
     * 用户名 （默认插入数据时以身份证号填充）
     */
    private String fcustomername;
    /**
     * 密码 （默认插入时以身份证号后6位填充）
     */
    private String fpassword;
    /**
     * 电话号码
     */
    private String fphonenum;
    /**
     * 身份证号码
     */
    private String fidcard;
    /**
     * 性别（1：男，0：女） 
     */
    private String fgender;
    /**
     * 头像路径
     */
    private String fheadfile;
    /**
     * 是否删除 1：删除 0未删除  默认为0 默认启用
     */
    private String fisdelete;
    /**
     * 创建时间
     */
    private String fcreatetime;

}

