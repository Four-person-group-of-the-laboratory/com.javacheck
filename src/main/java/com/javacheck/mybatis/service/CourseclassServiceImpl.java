package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.dto.CourseclassDto;
import com.javacheck.mybatis.entity.Courseclass;
import com.javacheck.mybatis.mapper.ClassStudentMapper;
import com.javacheck.mybatis.mapper.CourseclassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lijincan
 * @date: 2019年12月07日 16:56
 * @Description: TODO
 */
@Component
public class CourseclassServiceImpl extends ServiceImpl<CourseclassMapper,Courseclass> implements CourseclassService{
    @Autowired
    CourseclassMapper courseclassMapper;
    @Autowired
    ClassStudentService classStudentService;
    @Override
    public Courseclass QueryCourseclassById(Integer id) {
        return courseclassMapper.selectById(id);
    }

    @Override
    public List<CourseclassDto> QueryAll() {
        EntityWrapper<Courseclass> entityWrapper = new EntityWrapper();
        entityWrapper.isNotEmptyOfWhere();

        List<CourseclassDto> courseclassDtoList = new ArrayList();
        List<Courseclass> courseclassList = courseclassMapper.selectList(entityWrapper);
        for (Integer i = 0; i < courseclassList.size(); i++){
            CourseclassDto courseclassDto = new CourseclassDto();

            courseclassDto.setCount(classStudentService.CountStudentByCourseClassId(courseclassList.get(i).getId()));
            courseclassDto.setCourseclassname(courseclassList.get(i).getName());
            courseclassDto.setId(courseclassList.get(i).getId());

            courseclassDtoList.add(courseclassDto);
        }


        return  courseclassDtoList;
    }
}
