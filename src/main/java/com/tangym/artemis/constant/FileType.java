package com.tangym.artemis.constant;

/**
 * @author backtym@live.cn
 * @date 2020/10/30 10:10
 */
public enum FileType {
    CSV("csv",".csv"), JMX("jmx",".jmx"),;
    private String name;
    private String suffix;

    FileType(String name, String suffix) {
        this.name=name;
        this.suffix=suffix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
