package com.estranger.www.atomikos.config;

import com.estranger.www.atomikos.datasource.DynamicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author：Estranger
 * Description：Mybatis配置类
 * Date：2020/7/24
 */
@Configuration
public class MybatisConfig {

    final static String MASTER_PREFIX = "spring.jta.atomikos.datasource.master";
    final static String SLAVE_PREFIX = "spring.jta.atomikos.datasource.slave";


    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasPackage;


    @Bean
    @ConfigurationProperties(prefix = MASTER_PREFIX)
    public DataSource master(){
        return new AtomikosDataSourceBean();
    }

    @Bean
    @ConfigurationProperties(prefix = SLAVE_PREFIX)
    public DataSource slave(){
        return new AtomikosDataSourceBean();
    }

    /**
     * 动态数据源配置
     */
    @Bean
    @Primary
    public DataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> targetDataSources = new HashMap();
        //添加数据源
        targetDataSources.put("master",master());
        targetDataSources.put("slave",slave());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(master());
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置动态datasource
        sqlSessionFactoryBean.setDataSource(dataSource());
        //设置bean包扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        //设置xml包扫描路径
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
        return sqlSessionFactoryBean;
    }

    /**
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
