package com.javacheck.mybatis.dto;

import com.javacheck.mybatis.entity.Courseclass;
import lombok.Data;

import java.util.List;

/**
 * @author: lijincan
 * @date: 2020年03月15日 9:23
 * @Description: TODO
 */
@Data
public class CourseclassDto {
    private String courseclassname;
    private Integer id;
    private Integer count;//人数
}
