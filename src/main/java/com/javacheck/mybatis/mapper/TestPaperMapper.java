package com.javacheck.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.javacheck.mybatis.entity.TestPaper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TestPaperMapper extends BaseMapper<TestPaper>{

    Long getTotal();

    List<TestPaper> getAllTestPaper(@Param("page") Integer page, @Param("size") Integer size);

}
