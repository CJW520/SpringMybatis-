package com.cjw.filter;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.cjw.datasource.DataSourceEntity;
import com.cjw.datasource.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤开启");
    }

    /**
     * 这个方法完成实际的过滤操作，当客户请求访问与过滤器相关联的URL的时候，Servlet过滤器将先执行doFilter方法，FilterChain参数用于访问后续过滤器
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始过滤");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURL().toString();
        String urls = request.getRequestURI();
        log.info("请求IP:" + servletRequest.getRemoteAddr());
        //请求IP:192.168.10.100
        log.info("请求url:" + url);
        // 请求url:http://192.168.10.130:8080/index.html
        log.info("请求url:" + urls);
        /*       请求url:/index.html
        System.out.println("进入过滤器");
        if (urls.contains("index")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else
        {
            HttpServletResponse res =(HttpServletResponse)servletResponse;
            res.sendRedirect("/index.html");
        }*/

        log.info("过滤完成");
        filterChain.doFilter(servletRequest, servletResponse);

//        System.out.println("执行过滤器");
    }

    /**
     * filter创建后会保存在内存中，当web应用移除或者服务器停止时才销毁，该方法在Filter的生命周期中仅执行一次，在这个方法中，可以释放过滤器使用的资源
     */
    @Override
    public void destroy() {
        log.info("关闭过滤");
    }

}