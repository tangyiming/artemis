package com.tangym.artemis.config;

import com.tangym.artemis.exception.GlobalDefaultExceptionHandler;
import com.tangym.artemis.advice.CommonResponseDataAdvice;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * {@link GlobalDefaultExceptionHandler} {@link CommonResponseDataAdvice} bean配置加载
 *
 * @author backtym@live.cn
 */
@Configuration
@EnableConfigurationProperties(GlobalDefaultProperties.class)
@PropertySource(value = "classpath:dispose.properties", encoding = "UTF-8")
public class GlobalDefaultConfiguration {

    @Bean
    public GlobalDefaultExceptionHandler globalDefaultExceptionHandler() {
        return new GlobalDefaultExceptionHandler();
    }

    @Bean
    public CommonResponseDataAdvice xlCommonResponseDataAdvice(GlobalDefaultProperties globalDefaultProperties) {
        return new CommonResponseDataAdvice(globalDefaultProperties);
    }

}
