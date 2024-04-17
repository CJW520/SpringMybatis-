package com.cjw.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MSI
 */
@Slf4j
public class DataSourceContextHolder {
    private static final ThreadLocal<String> DATASOURCE_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dataSourceName 数据源名称
     */
    public static void setDataSource(String dataSourceName) {
        DATASOURCE_HOLDER.set(dataSourceName);
    }

    /**
     * 获取当前线程的数据源
     *
     * @return 数据源名称
     */
    public static String getDataSource() {
        return DATASOURCE_HOLDER.get();
    }

    /**
     * 删除当前数据源
     */
    public static void removeDataSource() {
        DATASOURCE_HOLDER.remove();
    }


}