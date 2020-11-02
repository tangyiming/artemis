package com.tangym.artemis.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * jenkins服务
 *
 * @author backtym@live.cn
 * @date 2020/10/27 13:13
 */
@Service
public interface JenkinsServiceI {

    /**
     * 带参构建job
     *
     * @param jobName job名
     * @param params  job所需参数
     * @return 构建号等
     * @throws URISyntaxException
     * @throws IOException
     */
    Map buildWithParameters(String jobName, Map<String, String> params) throws IOException;

    /**
     * 获取构建结果
     *
     * @param jobName  job名
     * @param buildNum 构建数
     * @return 构建结果
     */
    Map result(String jobName, Integer buildNum) throws IOException;
}
