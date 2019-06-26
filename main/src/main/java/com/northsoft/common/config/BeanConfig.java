package com.northsoft.common.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuyi
 * @email 343368666@qq.com
 * @date 19-6-25
 */
@Configuration
public class BeanConfig {

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }

}
