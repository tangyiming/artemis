package com.tangym.artemis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseCRUDManager;
import com.tangym.artemis.constant.UserRole;
import com.tangym.artemis.entity.SysUser;
import com.tangym.artemis.exception.category.BusinessException;
import com.tangym.artemis.mapper.SysUserMapper;
import com.tangym.artemis.service.SysUserServiceI;
import com.tangym.artemis.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Resource
//    private SysUserMapper sysUserMapper;

    @Autowired
    private BaseCRUDManager baseCRUDManager;

    @Override
    public String login(final SysUser sysUser) {
        try {
            // 验证用户名和密码是否对的
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(sysUser.getUserid(),
                            sysUser.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BusinessException("ERROR", "用户名或者密码不正确");
        }
        // 生成Token与查询用户权限
//        SysUser condition = new sysUser();
//        condition.setUserid(sysUser.getUserid());
//        Wrapper<SysUser> conditionWrapper = new QueryWrapper<>(condition);
//        SysUser sysUserData = sysUserMapper.selectOne(conditionWrapper);
        SysUser sysUserData = baseCRUDManager.selectOne(SysUser.builder().userid(sysUser.getUserid()).build());
        return tokenUtil.createToken(sysUserData);
    }

    @Override
    public String register(SysUser sysUser) {
        try {
            // 密码加密存储
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode(sysUser.getPassword());
            sysUser.setPassword(password);
            // 注册时，默认admin为管理员账户，其他为普通用户
            if (UserRole.ADMIN.getRole().equalsIgnoreCase(sysUser.getUserid())) {
                sysUser.setUserRole(UserRole.ADMIN.getRole());
            }
            sysUser.setUserRole(UserRole.USER.getRole());
//            sysUserMapper.insert(sysUser);
            baseCRUDManager.insert(sysUser);
        } catch (DataAccessException e) {
            throw new BusinessException("ERROR", "已经存在该用户名或者用户昵称，或者用户权限出错");
        }
        return "用户注册成功";
    }
}
