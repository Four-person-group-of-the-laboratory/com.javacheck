package com.javacheck.mybatis.controller;

import com.javacheck.mybatis.dto.CourseclassDto;
import com.javacheck.mybatis.dto.RestResult;
import com.javacheck.mybatis.dto.ResultCode;
import com.javacheck.mybatis.service.CourseclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lijincan
 * @date: 2020年03月14日 19:38
 * @Description: TODO
 */
@RestController
@RequestMapping("courseclass")
public class CourseclassController {
    @Autowired
    CourseclassService courseclassService;

    @GetMapping("/query/")
    public RestResult getallcourseclass(){
        RestResult restResult = new RestResult();

        try {
            restResult.setData(courseclassService.QueryAll());
            restResult.setCode(ResultCode.SUCCESS);
            restResult.setMessage("获取班级数据成功");
            System.out.println("获取班级数据成功");
            return restResult;
        }catch (Exception e){
            System.out.println(e);
            restResult.setCode(ResultCode.FAIL);
            restResult.setMessage("获取班级数据失败");
            return restResult;
        }
    }
}
