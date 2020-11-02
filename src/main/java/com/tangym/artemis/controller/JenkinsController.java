package com.tangym.artemis.controller;

import com.tangym.artemis.service.JenkinsServiceI;
import com.tangym.artemis.vo.BuildJobParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * 调用jenkins
 *
 * @author backtym@live.cn
 * @date 2020/10/27 12:43
 */
@RestController
@RequestMapping("/jenkins")
public class JenkinsController {
    @Resource
    private JenkinsServiceI jenkinsServiceI;

    @PostMapping(value = "/build")
    public Map buildWithParameters(@RequestBody BuildJobParameters buildJobParameters) throws IOException {
        return jenkinsServiceI.buildWithParameters(buildJobParameters.getJobName(), buildJobParameters.getParams());
    }

    @PostMapping(value = "/result")
    public Map Result(String jobName, Integer buildNum) throws IOException {
        return jenkinsServiceI.result(jobName, buildNum);
    }

}
