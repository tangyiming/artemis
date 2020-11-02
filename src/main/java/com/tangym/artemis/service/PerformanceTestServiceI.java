package com.tangym.artemis.service;

import com.tangym.artemis.request.TestInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author backtym@live.cn
 * @date 2020/10/30 10:27
 */
@Service
public interface PerformanceTestServiceI {
    /**
     * 多文件与测试信息保存接口
     *
     * @param info  测试计划信息，包括测试meta信息
     * @param files 该测试计划所用到的文件
     * @return
     */
    String save(TestInfo info, List<MultipartFile> files);
}
