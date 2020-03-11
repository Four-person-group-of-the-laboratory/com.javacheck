package com.javacheck.mybatis.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.javacheck.mybatis.entity.SysUser;
import com.javacheck.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lijincan
 * @date: 2020年03月10日 14:07
 * @Description: TODO
 */
@Component
public class SysUserServicelmpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public SysUser QuerySysUserById(Integer id) {
        return sysUserMapper.selectById(id);
    }
}
