package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.javacheck.mybatis.entity.Paper_Courserclass;
import com.javacheck.mybatis.entity.RespPageEntity;

import java.util.List;

public interface Paper_CourserclassService extends IService<Paper_Courserclass>{

    List<Paper_Courserclass> getPaper_CourserclassByPaperId(Integer id);

}
