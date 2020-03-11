package com.javacheck.mybatis.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author: lijincan
 * @date: 2020年03月10日 13:05
 * @Description: TODO
 */
@TableName("kh_class_student")
@Data
public class ClassStudent {
    private String account;
    private int courseclass_id;
    private String comment;
}
