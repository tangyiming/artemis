package com.tangym.artemis.service.impl;

import com.tangym.artemis.request.Info;
import com.tangym.artemis.service.FileServiceI;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author backtym@live.cn
 * @date 2020/10/29 19:23
 */
@Component
public class FileServiceImpl implements FileServiceI {

    /**
     * 上传文件
     *
     * @param files  文件列表
     * @param info Json格式的Info对象
     * @throws IOException IO异常
     */
    @Override
    public void uploadFilesAndReqeust(List<MultipartFile> files, Info info) throws IOException {
        //todo 从PerformanceTestImpl.save这里抽出通用方法
    }
}
