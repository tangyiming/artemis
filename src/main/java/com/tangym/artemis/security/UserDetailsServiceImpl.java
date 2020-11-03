package com.tangym.artemis.security;

//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseCRUDManager;
import com.tangym.artemis.entity.SysUser;
//import com.tangym.artemis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author backtym@live.cn
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Resource
//    private SysUserMapper sysUserMapper;

    @Autowired
    private BaseCRUDManager baseCRUDManager;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

//        SysUser condition = new SysUser();
//        condition.setUserid(userid);
//        Wrapper<SysUser> conditionWrapper = new QueryWrapper<>(condition);
//        SysUser sysUser = sysUserMapper.selectOne(conditionWrapper);
        SysUser sysUser = baseCRUDManager.selectOne(SysUser.builder().userid(userid).build());


        if (sysUser == null) {
            throw new UsernameNotFoundException(userid);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // Spring Security 角色名称默认使用 "ROLE_" 开头
        // authorities.add 可以增加多个用户角色，对于一个用户有多种角色的系统来说，
        // 可以通过增加用户角色表、用户--角色映射表，存储多个用户角色信息
        authorities.add(new SimpleGrantedAuthority("ROLE_" + sysUser.getUserRole()));
        // 给 Spring Security 传入用户名、用户密码、用户角色。
        return new User(sysUser.getUserid(), sysUser.getPassword(), authorities);
    }
}