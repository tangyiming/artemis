package com.tangym.artemis.controller;

import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseCRUDManager;
import com.tangym.artemis.entity.SysUser;
import com.tangym.artemis.mapper.SysUserMapper;
import com.tangym.artemis.service.SysUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户
 *
 * @author backtym@live.cn
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    SysUserMapper sysUserMapper;
    @Resource
    private SysUserServiceI sysUserServiceI;
    @Autowired
    private BaseCRUDManager baseCRUDManager;


    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public String register(@RequestBody @Valid final SysUser sysUser) {
        return sysUserServiceI.register(sysUser);
    }

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestBody final SysUser sysUser) throws AuthenticationException {
        return sysUserServiceI.login(sysUser);
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("/all")
    public List<SysUser> all() {
//        return sysUserMapper.selectList(null);
        return baseCRUDManager.selectAll(SysUser.class);

    }

    /**
     * 这是登录用户才可以看到的内容
     */
    @PostMapping(value = "/message", produces = "application/json;charset=UTF-8")
    //produces="application/json;charset=UTF-8"
    // 使无法按照json解析的数据最后以统一返回格式的json格式返回
    public String message() {
        return "这个消息只有登录用户才可以看到";
    }

    /**
     * 这是管理员用户才可以看到
     */
    @PostMapping(value = "/admin", produces = "application/json;charset=UTF-8")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "这个消息只有管理员用户才可以看到";
    }
}