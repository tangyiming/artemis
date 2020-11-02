package com.tangym.artemis;

import com.tangym.artemis.annotation.EnableGlobalDispose;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author backtym@live.cn
 */
@MapperScan("com.tangym.artemis.mapper") //不明确到mapper层级 报错Invalid bound statement (not found)
@EnableGlobalDispose
@SpringBootApplication
public class ArtemisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisApplication.class, args);
    }

}
