package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value={
        "com.damg.upit.monitor.dailyCheck.domain.mainDaily.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.infraDaily.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.infraServerMonitor.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.gwServerMonitor.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.gwDaily.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.etcServerMonitor.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.etcDaily.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.erpServerMonitor.mapper",
        "com.damg.upit.monitor.dailyCheck.domain.erpDaily.mapper"})
public class mainDataSourceConfig {

    private final String MAIN_DATASOURCE = "mainDataSource";

    @Primary
    @Bean(MAIN_DATASOURCE)
    @ConfigurationProperties(prefix="spring.monitor-db.datasource")
    public DataSource mainDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public SqlSessionFactory mainSessionFactory(DataSource mainDataSource) throws Exception{

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(mainDataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml");
        bean.setMapperLocations(res);

        return bean.getObject();
    }

    @Primary
    @Bean
    public DataSourceTransactionManager mainTransactionManager(DataSource mainDataSource){
        return new DataSourceTransactionManager(mainDataSource);
    }
}
