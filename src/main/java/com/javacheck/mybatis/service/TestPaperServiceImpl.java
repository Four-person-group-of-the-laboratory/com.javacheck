package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.entity.TestPaper;
import com.javacheck.mybatis.entity.RespPageEntity;
import com.javacheck.mybatis.mapper.TestPaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author: lijincan
 * @date: 2019年12月07日 16:59
 * @Description: TODO
 */
@Component
public class TestPaperServiceImpl extends ServiceImpl<TestPaperMapper,TestPaper> implements TestPaperService{

    @Autowired
    TestPaperMapper testPaperMapper;

    @Transactional
    public RespPageEntity getAllTestPaper(Integer page, Integer size) {
        RespPageEntity pageEntity = new RespPageEntity();
        // 默认从0开始
        if (page != null && size != null) {
            page = (page-1)*size;
        }

        // 获取考试信息
        List<TestPaper> paper_Courserclass =  testPaperMapper.getAllTestPaper(page, size);
        pageEntity.setData(paper_Courserclass);
        // 获取总量
        Long total = testPaperMapper.getTotal();
        pageEntity.setTotal(total);

        return pageEntity;
    }

    @Override
    public List<TestPaper> QueryPaper(Integer page, Integer size, String name, Integer type, Integer college) {
        EntityWrapper<TestPaper> wrapper = new EntityWrapper();
        if(name == "" && type == null && college ==null){

        } else if(type == null || college ==null){
            wrapper.like("name", name).or().eq("type_id",type).or().eq("college_id",college);
        }else {
            wrapper.like("name", name).and().eq("type_id",type).eq("college_id",college);
        }
        Page<TestPaper> p = new Page<>(page,size);

        List<TestPaper> list =testPaperMapper.selectPage(p,wrapper);
        return list;
    }

    @Override
    public Long getTotal() {
        return testPaperMapper.getTotal();
    }
}
