package com.pings.mybills.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *********************************************************
 ** @desc  ： 图表预览
 ** @author  Pings
 ** @date    2017/11/1
 ** @version v1.0
 * *******************************************************
 */
@Configuration
//**扫描mapper包
@MapperScan(basePackages = {"com.pings.mybills.*.dao"})
public class MybatisPlusConfig {

    /**定义MybatisPlus分页插件*/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
