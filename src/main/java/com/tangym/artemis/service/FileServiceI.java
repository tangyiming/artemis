package com.tangym.artemis.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件服务
 *
 * @author backtym@live.cn
 * @date 2020/10/29 19:23
 */
@Service
public interface FileServiceI {

    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 路径
     * @return 成功与否信息
     * @throws IOException IO异常
     */
    String save(MultipartFile file, String path) throws IOException;

}
