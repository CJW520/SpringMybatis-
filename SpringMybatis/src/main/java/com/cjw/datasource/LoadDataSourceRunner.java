package com.cjw.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author MSI
 */
@Slf4j
@Component
public class LoadDataSourceRunner implements CommandLineRunner {
    @Resource
    private DynamicDataSource dynamicDataSource;


    @Override
    public void run(String... args) throws Exception {
        log.info("进入LoadDataSourceRunner");
        dynamicDataSource.setDataSours("db3", getDataSource());
    }

    public DataSource getDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@192.168.10.100:1521:orcl");
        dataSource.setUsername("TEST");
        dataSource.setPassword("TEST");
        return dataSource;
    }


}