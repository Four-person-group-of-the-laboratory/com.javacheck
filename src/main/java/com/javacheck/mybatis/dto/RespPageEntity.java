package com.javacheck.mybatis.dto;

import lombok.Data;

import java.util.List;

/**
 * @author lijincan
 * @DESCRIPTION 分页传值类
 */
@Data
public class RespPageEntity {
    private List<?> data;
    private Long total;
}
