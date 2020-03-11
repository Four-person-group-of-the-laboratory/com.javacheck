package com.javacheck.mybatis.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: lijincan
 * @date: 2020年02月05日 18:19
 * @Description: TODO
 */
@Data
public class TestDetil {
    private String papername;
    private String courseclassname;
    private String teacher;
    private Date start_time;
    private Date end_time;
    private Integer stuent_cout;
}
