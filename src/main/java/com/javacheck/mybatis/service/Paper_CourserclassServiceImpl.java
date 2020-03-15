package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.entity.Paper_Courserclass;
import com.javacheck.mybatis.mapper.Paper_CourserclassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: lijincan
 * @date: 2019年12月07日 16:57
 * @Description: TODO
 */
@Component
public class Paper_CourserclassServiceImpl extends ServiceImpl<Paper_CourserclassMapper,Paper_Courserclass> implements Paper_CourserclassService{

    @Autowired
    private Paper_CourserclassMapper paper_courserclassMapper;


    @Override
    public List<Paper_Courserclass> getPaper_CourserclassByPaperId(Integer id) {
        EntityWrapper<Paper_Courserclass> wrapper= new EntityWrapper();
        wrapper.eq("testpaper_id",id);

        Paper_Courserclass paper_courserclass = new Paper_Courserclass();
        paper_courserclass.setTestpaper_id(id);
        paper_courserclass.setDel_flag("1");
        System.out.println("查找试卷对应教学班级："+paper_courserclassMapper.selectList(wrapper));
        return paper_courserclassMapper.selectList(wrapper);
    }
}
