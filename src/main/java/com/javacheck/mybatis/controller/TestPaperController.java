package com.javacheck.mybatis.controller;

import com.javacheck.mybatis.dto.RespPageEntity;
import com.javacheck.mybatis.dto.RestResult;
import com.javacheck.mybatis.dto.ResultCode;
import com.javacheck.mybatis.dto.TestDetil;
import com.javacheck.mybatis.entity.*;
import com.javacheck.mybatis.service.*;
import com.javacheck.mybatis.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("testpaper")
public class TestPaperController {

    @Autowired
    private ResultGenerator resultGenerator;
    @Autowired
    private Paper_CourserclassService paper_courserclassService;
    @Autowired
    private TestPaperService testPaperService;
    @Autowired
    private ClassStudentService classStudentService;
    @Autowired
    private CourseclassService courseclassService;
    @Autowired
    private SysUserService sysUserService;


    @GetMapping("/page/")
    public RestResult getAllUserByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {

        RespPageEntity respPageEntity = testPaperService.getAllTestPaper(page, size);
        System.out.println("共"+respPageEntity.getTotal()+"条数据");
        RestResult restResult = new RestResult();

        try {
            restResult.setData(respPageEntity);
            restResult.setCode(ResultCode.SUCCESS);
        }catch (Exception e){
            restResult.setCode(ResultCode.FAIL);
            restResult.setMessage("错误");
        }
        return restResult;
    }
    @GetMapping("/query/")
    public RestResult QueryPaper(@RequestParam("page") Integer page, @RequestParam("size") Integer size,@RequestParam("name") String name,
                                     @RequestParam("type")Integer type,@RequestParam("college")Integer college){
        System.out.println(page+"--"+size+"--"+name+"--"+type+"--"+college);

        RespPageEntity respPageEntity = new RespPageEntity();
        respPageEntity.setTotal(testPaperService.getTotal());
        respPageEntity.setData(testPaperService.QueryPaper(page, size,name,type,college));

        RestResult restResult = new RestResult();
        try {
            System.out.println(respPageEntity.getData()+"--"+respPageEntity.getTotal());
            restResult.setData(respPageEntity);
            restResult.setCode(ResultCode.SUCCESS);
        }catch (Exception e){
            restResult.setCode(ResultCode.FAIL);
            restResult.setMessage("获取试卷列表失败");
        }
        return restResult;
    }
    @GetMapping("/testdetail/")
    public RestResult getTestDetail(@RequestParam("TestPaperId") Integer id){
        Integer studentcount = classStudentService.CountStudentByCourseClassId(id);
        List<Paper_Courserclass> paper_courserclass = paper_courserclassService.getPaper_CourserclassByPaperId(id);
        Paper_Courserclass paper_class = paper_courserclass.get(0);
        TestPaper testPaper = testPaperService.QueryPaperById(id);

        Integer courseclassid = paper_class.getCourserclass_id();
        Courseclass courseclass = courseclassService.QueryCourseclassById(courseclassid);

        Integer sysuserid = courseclass.getTeacher_id();
        SysUser sysUser = sysUserService.QuerySysUserById(sysuserid);
        TestDetil testDetil = new TestDetil();

        testDetil.setPapername(testPaper.getName());
        testDetil.setStart_time(paper_class.getStart_time());
        testDetil.setEnd_time(paper_class.getEnd_time());
        testDetil.setStuent_cout(studentcount);
        testDetil.setCourseclassname(courseclass.getName());
        testDetil.setTeacher(sysUser.getName());

        List<TestDetil> testDetilList = new ArrayList<>();
        testDetilList.add(testDetil);

        System.out.println(testDetil);
        RestResult restResult = new RestResult();
        try{
            restResult.setData(testDetilList);
            restResult.setCode(ResultCode.SUCCESS);
        }catch (Exception e){
            restResult.setCode(ResultCode.FAIL);
        }
        return restResult;
    }


    /**
     * 为参数验证添加异常处理器
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult handleConstraintViolationException(ConstraintViolationException cve) {
        //这里简化处理了，cve.getConstraintViolations 会得到所有错误信息的迭代，可以酌情处理
        String errorMessage = cve.getConstraintViolations().iterator().next().getMessage();
        return resultGenerator.getFailResult(errorMessage);
    }
}
