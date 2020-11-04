package com.tangym.artemis.constant;

/**
 * @author backtym@live.cn
 * @date 2020/11/3 21:45
 */
public enum UserRole {
    ADMIN("ADMIN", "管理员"), USER("USER", "普通用户"),
    ;

    private String role;
    private String desc;

    UserRole(String role, String desc) {
        this.desc = desc;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
