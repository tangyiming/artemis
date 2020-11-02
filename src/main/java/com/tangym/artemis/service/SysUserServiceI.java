package com.tangym.artemis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tangym.artemis.entity.SysUser;
import org.springframework.security.core.AuthenticationException;


/**
 * 用户服务
 *
 * @author backtym@live.cn
 */
public interface SysUserServiceI extends IService<SysUser> {

    /**
     * 用户登录
     *
     * @param sysUser 用户登录的用户名和密码
     * @return 用户登录成功返回的Token
     * @throws AuthenticationException 身份验证错误抛出异常
     */
    Object login(final SysUser sysUser);

    /**
     * 用户注册
     *
     * @param sysUser 用户注册信息
     * @return 用户注册结果
     */
    String register(SysUser sysUser);

}
