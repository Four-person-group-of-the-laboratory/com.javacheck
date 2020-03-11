package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.entity.Courseclass;
import com.javacheck.mybatis.entity.RespPageEntity;
import com.javacheck.mybatis.mapper.CourseclassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author: lijincan
 * @date: 2019年12月07日 16:56
 * @Description: TODO
 */
@Component
public class CourseclassServiceImpl extends ServiceImpl<CourseclassMapper,Courseclass> implements CourseclassService{
    @Autowired
    CourseclassMapper courseclassMapper;
    @Override
    public Courseclass QueryCourseclassById(Integer id) {
        return courseclassMapper.selectById(id);
    }
}
