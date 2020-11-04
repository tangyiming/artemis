package com.tangym.artemis.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.*;

import java.sql.Timestamp;

/**
 * 平台测试，部署等项目表
 *
 * @author backtym@live.cn
 * @date 2020/11/3 21:32
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
public class Project extends BaseModel {
    private static final long serialVersionUID = 4047547271692083826L;

    /**
     * 项目id
     */
    @Column(name = "id", type = MySqlTypeConstant.INT, length = 11, isKey = true, isAutoIncrement = true)
    private Integer id;

    /**
     * 项目名
     */
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String name;

    /**
     * 项目类型
     */
    @Column(name = "type", type = MySqlTypeConstant.VARCHAR, length = 8)
    private String type;

    /**
     * 项目说明
     */
    @Column(name = "description", type = MySqlTypeConstant.VARCHAR, length = 64)
    private String description;

    /**
     * 项目状态
     * disable / enable
     */
    @Column(name = "status", type = MySqlTypeConstant.BIT, length = 1)
    private String status;

    /**
     * 项目创建人
     * <p>
     * user 字段为 sysUser表 userid
     */
    @Column(name = "create_user", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String createUser;

    /**
     * 项目创建时间
     */
    @Column(name = "create_time", type = MySqlTypeConstant.DATETIME)
    private Timestamp createTime;

    /**
     * 项目最近修改时间
     */
    @Column(name = "update_time", type = MySqlTypeConstant.DATETIME)
    private Timestamp updateTime;

    /**
     * 项目最近修改人
     * user 字段为 sysUser表 userid
     */
    @Column(name = "update_user", type = MySqlTypeConstant.VARCHAR, length = 32)
    private String updateUser;

    /**
     * 扩展信息字段，针对不同类型的项目，可以存储特殊信息
     */
    @Column(name = "attribute_json_text", type = MySqlTypeConstant.VARCHAR, length = 255)
    private String attributeJsonText;

}
