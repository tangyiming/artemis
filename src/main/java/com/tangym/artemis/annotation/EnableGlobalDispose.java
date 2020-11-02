package com.tangym.artemis.annotation;

import com.tangym.artemis.config.GlobalDefaultConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author backtym@live.cn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(GlobalDefaultConfiguration.class)
public @interface EnableGlobalDispose {

}
