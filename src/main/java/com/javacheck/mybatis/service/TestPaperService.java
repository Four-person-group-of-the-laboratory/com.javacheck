package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.javacheck.mybatis.entity.TestPaper;
import com.javacheck.mybatis.entity.RespPageEntity;

import java.util.List;

public interface TestPaperService extends IService<TestPaper>{

    RespPageEntity getAllTestPaper(Integer page, Integer size);

    List<TestPaper> QueryPaper(Integer page, Integer size, String name, Integer type, Integer college);

    TestPaper QueryPaperById(Integer id);
    Long getTotal();
}
