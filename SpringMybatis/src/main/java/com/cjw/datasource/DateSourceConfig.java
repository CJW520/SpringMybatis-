package com.cjw.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.cjw.model.User;
import com.cjw.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DateSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.db1")
    public DataSource db1(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.druid.db2")
    public DataSource db2(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource createDynamicDataSource(){
        Map<Object,Object> dataSourceMap = new HashMap<>();
        DataSource defaultDataSource = db1();
        dataSourceMap.put("db1",defaultDataSource);
        dataSourceMap.put("db2",db2());
        System.out.println( "设置默认数据源DB1,Db2");
        //设置默认数据源
        return new DynamicDataSource(defaultDataSource,dataSourceMap);
    }





}