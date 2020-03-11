package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.entity.ClassStudent;
import com.javacheck.mybatis.mapper.ClassStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lijincan
 * @date: 2020年03月10日 13:19
 * @Description: TODO
 */
@Component
public class ClassStudentServicelmpl extends ServiceImpl<ClassStudentMapper, ClassStudent> implements ClassStudentService{
    @Autowired
    private ClassStudentMapper classStudentMapper;

    @Override
    public Integer CountStudentByCourseClassId(Integer id) {
        EntityWrapper<ClassStudent> wrapper = new EntityWrapper();
        wrapper.eq("courseclass_id",id);
        System.out.println("人数为"+classStudentMapper.selectCount(wrapper));
        return classStudentMapper.selectCount(wrapper);
    }
}
