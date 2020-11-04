package com.tangym.artemis.service;

import com.tangym.artemis.request.Info;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
     * @param files  文件列表
     * @param info Json格式的Info对象
     * @throws IOException IO异常
     */
    void uploadFilesAndReqeust(List<MultipartFile> files, Info info) throws IOException;

}
