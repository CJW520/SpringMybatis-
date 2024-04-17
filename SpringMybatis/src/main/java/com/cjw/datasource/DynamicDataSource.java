package com.cjw.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @author MSI
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    private final Map<Object, Object> targetDataSourceMap;

    public DynamicDataSource(DataSource defaultDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(targetDataSources);
        this.targetDataSourceMap = targetDataSources;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }

    /**
     * 添加数据源信息
     *
     * @param dataSources 数据源实体集合
     * @return 返回添加结果
     */
    public Boolean createDataSource(List<DataSourceEntity> dataSources) {
        try {
            if (CollectionUtils.isNotEmpty(dataSources)) {
                for (DataSourceEntity ds : dataSources) {
                    //校验数据库是否可以连接
                    Class.forName(ds.getDriverClassName());
                    DriverManager.getConnection(ds.getUrl(), ds.getUserName(), ds.getPassWord());
                    //定义数据源
                    DruidDataSource dataSource = new DruidDataSource();
                    BeanUtils.copyProperties(ds, dataSource);
                    //申请连接时执行validationQuery检测连接是否有效，这里建议配置为TRUE，防止取到的连接不可用
                    dataSource.setTestOnBorrow(true);
                    //建议配置为true，不影响性能，并且保证安全性。
                    //申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
                    dataSource.setTestWhileIdle(true);
                    //用来检测连接是否有效的sql，要求是一个查询语句。
                    if (ds.getUrl().contains("oracle")) {
                        dataSource.setValidationQuery("select 1 from dual");
                    } else {
                        dataSource.setValidationQuery("select 1 ");
                    }
                    dataSource.init();
                    this.targetDataSourceMap.put(ds.getKey(), dataSource);
                }
                super.setTargetDataSources(this.targetDataSourceMap);
                // 将TargetDataSources中的连接信息放入resolvedDataSources管理
                super.afterPropertiesSet();
                return Boolean.TRUE;
            }
        } catch (ClassNotFoundException | SQLException e) {
            log.error("---程序报错---:{}", e.getMessage());
        }
        return Boolean.FALSE;
    }

    /**
     * 校验数据源是否存在
     *
     * @param key 数据源保存的key
     * @return 返回结果，true：存在，false：不存在
     */
    public boolean existsDataSource(String key) {
        return Objects.nonNull(this.targetDataSourceMap.get(key));
    }

    public boolean delDataSource(String key) {
        return Objects.nonNull(this.targetDataSourceMap.remove(key));
    }


    public void setDataSours(String key, DataSource dataSource) {
        List<DataSourceEntity> ds = new ArrayList<>();
        DataSourceEntity sourceEntity = new DataSourceEntity();
        BeanUtils.copyProperties(dataSource, sourceEntity);
        sourceEntity.setKey(key);
        ds.add(sourceEntity);
        if (this.existsDataSource(key)) {
            log.info("已有数据源{}，已删除", key);
            this.delDataSource(key);
        }
        log.info("已重新配置置数据源{}", key);
        Object a = DataSourceContextHolder.getDataSource();
        log.info(this.createDataSource(ds) ? "创建数据源" + key + "成功" : "创建数据源" + key + "失败");
    }
}