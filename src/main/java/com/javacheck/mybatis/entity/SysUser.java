package com.javacheck.mybatis.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * @author: lijincan
 * @date: 2020年03月10日 14:01
 * @Description: TODO
 */
@TableName("kh_sysuser")
@Data
public class SysUser {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private String account;
    private String password;
    private String name;
    private int sex;
    private String photo;
    private String phone;
    private String email;
    private int role;
    private int status;
    private String dept_id;
    private Date create_date;
    private String create_by;
    private Date update_date;
    private String update_by;
    private String remarks;
    private String del_flag;
}
