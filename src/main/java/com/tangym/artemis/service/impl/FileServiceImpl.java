package com.tangym.artemis.service.impl;

import com.tangym.artemis.constant.TestType;
import com.tangym.artemis.service.FileServiceI;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author backtym@live.cn
 * @date 2020/10/29 19:23
 */
@Component
public class FileServiceImpl implements FileServiceI {
    public static void main(String[] args) {

        System.out.println(TestType.valueOf("JMETER"));
    }

    @Override
    public String save(MultipartFile file, String path) throws IOException {
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
        return null;
    }
}
