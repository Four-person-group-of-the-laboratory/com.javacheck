package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.javacheck.mybatis.dto.CourseclassDto;
import com.javacheck.mybatis.entity.Courseclass;

import java.util.List;

public interface CourseclassService extends IService<Courseclass>{
    Courseclass QueryCourseclassById(Integer id);

    List<CourseclassDto> QueryAll();
}
