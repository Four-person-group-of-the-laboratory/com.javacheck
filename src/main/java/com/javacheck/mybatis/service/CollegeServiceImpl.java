package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.entity.College;
import com.javacheck.mybatis.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: lijincan
 * @date: 2019年12月07日 16:54
 * @Description: TODO
 */
@Component
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper,College> implements CollegeService{

    @Autowired
    CollegeMapper collegeMapper;
    @Override
    public String GetCollegeNameById(Integer id) {

        return collegeMapper.GetCollegeNameById(id);
    }

    public List<College> selectAll(){
        return (List<College>) collegeMapper.selectAll();
    }
}
