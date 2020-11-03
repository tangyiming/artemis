package com.tangym.artemis.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.annotation.Unique;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author backtym@live.cn
 * @since 2020-10-22
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
public class SysUser extends BaseModel {

    private static final long serialVersionUID = 874402310422940419L;
    /**
     * id
     */
    @Column(name = "id", type = MySqlTypeConstant.INT, length = 11, isKey = true, isAutoIncrement = true)
    private Integer id;

    /**
     * 用户id
     */
    @Unique
    @Column(name = "userid", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String userid;

    /**
     * 密码
     */
    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, length = 64)
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "username", type = MySqlTypeConstant.VARCHAR, length = 8)
    private String username;

    /**
     * 邮箱
     */
    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String email;

    /**
     * 部门
     */
    @Column(name = "bu", type = MySqlTypeConstant.VARCHAR, length = 16)
    private String bu;

    /**
     * 权限角色
     */
    @Column(name = "user_role", type = MySqlTypeConstant.VARCHAR, length = 8)
    private String userRole;
}
