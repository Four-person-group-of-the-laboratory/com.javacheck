package com.javacheck.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.javacheck.mybatis.entity.College;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegeMapper extends BaseMapper<College>{

    String GetCollegeNameById (@Param("id") Integer id);

    List<College> selectAll();

}
