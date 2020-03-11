package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.javacheck.mybatis.entity.ClassStudent;

public interface ClassStudentService extends IService<ClassStudent> {

    Integer CountStudentByCourseClassId (Integer id);
}
