package com.tangym.artemis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author backtym@live.cn
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门
     */
    private String bu;

    /**
     * 权限角色
     */
    private String userRole;


}
