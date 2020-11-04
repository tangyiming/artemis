package com.tangym.artemis.constant;

/**
 * @author backtym@live.cn
 * @date 2020/11/3 21:47
 */
public enum ProjectStatus {
    DISABLE("disable", 0), ENABLE("enabke", 1),
    ;

    private String status;
    private int value;

    ProjectStatus(String status, int value) {
        this.status = status;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
