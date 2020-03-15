package com.javacheck.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.javacheck.mybatis.entity.ClassStudent;
import com.javacheck.mybatis.entity.College;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ClassStudentMapper extends BaseMapper<ClassStudent>{

    public Integer CountStudentByCourseClassId(Integer id);
}
