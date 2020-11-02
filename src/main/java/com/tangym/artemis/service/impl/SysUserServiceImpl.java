package com.tangym.artemis.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangym.artemis.entity.SysUser;
import com.tangym.artemis.mapper.SysUserMapper;
import com.tangym.artemis.service.SysUserServiceI;
import com.tangym.artemis.utils.TokenUtil;
import com.tangym.artemis.exception.category.BusinessException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author backtym@live.cn
 * @since 2020-10-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserServiceI {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenUtil tokenUtil;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public Object login(final SysUser sysUser) {
        try {
            // 验证用户名和密码是否对的
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(sysUser.getUserid(),
                            sysUser.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BusinessException("ERROR", "用户名或者密码不正确");
        }
        // 生成Token与查询用户权限
        SysUser condition = new SysUser();
        condition.setUserid(sysUser.getUserid());
        Wrapper<SysUser> conditionWrapper = new QueryWrapper<>(condition);
        SysUser sysUserData = sysUserMapper.selectOne(conditionWrapper);
        return tokenUtil.createToken(sysUserData);
    }

    @Override
    public String register(SysUser sysUser) {
        try {
            // 密码加密存储
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode(sysUser.getPassword());
            sysUser.setPassword(password);
            sysUserMapper.insert(sysUser);
        } catch (DataAccessException e) {
            throw new BusinessException("ERROR", "已经存在该用户名或者用户昵称，或者用户权限出错");
        }
        return "用户注册成功";
    }
}
