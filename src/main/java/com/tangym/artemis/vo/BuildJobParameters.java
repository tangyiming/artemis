package com.tangym.artemis.vo;

import lombok.Data;

import java.io.File;
import java.util.Map;

/**
 * @author backtym@live.cn
 * @date 2020/10/27 13:54
 */
@Data
public class BuildJobParameters {
    private String jobName;
    private Map<String, String> params;
    private File file;
}
