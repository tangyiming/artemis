package com.tangym.artemis.request;

import lombok.Data;

/**
 * 测试计划信息
 *
 * @author backtym@live.cn
 * @date 2020/10/30 10:23
 */
@Data
public class TestInfo {
    private String testType;
    private String projectName;
    private String testPlanName;

}
