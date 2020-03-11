package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.javacheck.mybatis.entity.SysUser;
import com.javacheck.mybatis.mapper.SysUserMapper;

public interface SysUserService extends IService<SysUser> {
    SysUser QuerySysUserById(Integer id);
}
