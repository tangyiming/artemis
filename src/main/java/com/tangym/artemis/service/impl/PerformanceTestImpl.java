package com.tangym.artemis.service.impl;

import com.tangym.artemis.constant.FileType;
import com.tangym.artemis.constant.TestType;
import com.tangym.artemis.request.TestInfo;
import com.tangym.artemis.service.PerformanceTestServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author backtym@live.cn
 * @date 2020/10/30 10:28
 */
@Component
public class PerformanceTestImpl implements PerformanceTestServiceI {
    private static final Logger log = LoggerFactory.getLogger(PerformanceTestImpl.class);

    @Resource
    private Environment env;

    @Override
    public String save(TestInfo info, List<MultipartFile> files) {
        // 构造性能测试每个测试计划所需的测试文件对应的上传路径, e.g. /opt/perftest-data/登录平台查询构建结果1604047682147
        StringBuilder filePath = new StringBuilder();
        // 返回jmx文件路径，传给jenkins
        StringBuilder jmxPath= new StringBuilder();

        if (info.getTestType().equalsIgnoreCase(TestType.LOAD.name())) {
            filePath.append(env.getProperty("jmeter.upload.testdata-path"));
        }
        filePath.append(info.getTestPlanName()).append("_").append(System.currentTimeMillis());
        log.info("load test data update path: {}", filePath);
        jmxPath.append(filePath);

        // 创建文件夹
        File dir = new File(String.valueOf(filePath));
        if (!dir.exists()) {
            dir.mkdirs();
        }

        //解析上传文件到filePath下 csv/jmx/jar
        files.forEach(file -> {
            String filename= file.getOriginalFilename();
            File f = new File(filePath + File.separator + filename);
            if(filename.endsWith(FileType.JMX.getSuffix())) {
                jmxPath.append("/").append(filename);
                log.info("jmxPath:{}",jmxPath);
            }
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return jmxPath.toString();
    }

}
