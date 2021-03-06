package com.javacheck.mybatis.controller;

import com.javacheck.mybatis.dto.RestResult;
import com.javacheck.mybatis.dto.ResultCode;
import com.javacheck.mybatis.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lijincan
 * @date: 2020年03月09日 11:07
 * @Description: TODO
 */
@RestController
@RequestMapping("college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping ("/getcollege/")
    public RestResult getTestDetail(){

        System.out.println("学院有"+collegeService.selectAll());
        RestResult restResult = new RestResult();
        try{
            restResult.setData(collegeService.selectAll());
            restResult.setCode(ResultCode.SUCCESS);
            return restResult;
        }catch (Exception e){
            restResult.setCode(ResultCode.FAIL);
            restResult.setMessage("获取学院列表失败");
            return restResult;
        }
    }
}
