package com.tangym.artemis;

import com.tangym.artemis.annotation.EnableGlobalDispose;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author backtym@live.cn
 */
@MapperScan({"com.tangym.artemis.mapper", "com.gitee.sunchenbin.mybatis.actable.dao.*"})
//不明确到mapper层级 报错Invalid bound statement (not found)
@ComponentScan({"com.gitee.sunchenbin.mybatis.actable.manager.*", "com.tangym.artemis.*"})
@EnableGlobalDispose
@SpringBootApplication
public class ArtemisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisApplication.class, args);
    }

}
