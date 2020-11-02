package com.tangym.artemis.service.impl;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildResult;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.tangym.artemis.service.JenkinsServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author backtym@live.cn
 * @date 2020/10/27 13:15
 */
@Component
public class JenkinsServiceImpl implements JenkinsServiceI {
    private static final Logger log = LoggerFactory.getLogger(JenkinsServiceImpl.class);
    private static JenkinsServer jenkins;

    private final String server;
    private final String user;
    private final String password;

    private Environment environment;

    JenkinsServiceImpl(Environment environment) throws URISyntaxException {
        server = environment.getProperty("jenkins.server");
        user = environment.getProperty("jenkins.user");
        password = environment.getProperty("jenkins.password");
        jenkins = new JenkinsServer(new URI(server), user, password);
        //jenkins.close();
    }

    @Override
    public Map buildWithParameters(String jobName, Map<String, String> params) throws IOException {
        JobWithDetails job = jenkins.getJob(jobName);
        job.build(params, true);
        int buildNumber = job.getLastBuild().getNumber() + 1;
        Map m = new HashMap(8);
        m.put("buildNumber", buildNumber);
        return m;
    }

    @Override
    public Map result(String jobName, Integer buildNum) throws IOException {
        JobWithDetails job = jenkins.getJob(jobName);
        Build build = job.getBuildByNumber(buildNum);
        BuildResult result = build.details().getResult();
        Map m = new HashMap(8);
        m.put("buildResult", result);
        return m;
    }
}
