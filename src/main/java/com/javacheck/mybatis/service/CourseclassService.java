package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.javacheck.mybatis.entity.Courseclass;
import com.javacheck.mybatis.entity.RespPageEntity;

public interface CourseclassService extends IService<Courseclass>{
    Courseclass QueryCourseclassById(Integer id);
}
