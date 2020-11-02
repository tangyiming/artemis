package com.tangym.artemis.controller;

import com.tangym.artemis.request.TestInfo;
import com.tangym.artemis.service.PerformanceTestServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件上传
 *
 * @author backtym@live.cn
 * @date 2020/10/29 19:11
 */
@RestController
@RequestMapping("/perf")
public class PerformanceTestController {

    @Resource
    private PerformanceTestServiceI performanceTestServiceI;

    @PostMapping(value = "/save", consumes = {"multipart/form-data"})
    // =========== NOTE =============
    // 上传多文件列表与Json信息
    // 后端适用Postman的file 和 text 请求方法：@RequestParam(value = "info") String info,@RequestPart(value = "file") MultipartFile file
    // postman无法模拟以下这种请求
    // value 对应前端formdata用于接受多文件用的名字，springboot解析到files list上
    // info 在前端处理成json字符串，但是加入formData时，告知是json格式，RequestPart就可以解析成TestInfo对象
    // ==============================
    public String save(@RequestPart(value = "info") TestInfo info, @RequestPart(value = "file") List<MultipartFile> files) {
        return performanceTestServiceI.save(info, files);
    }
}



