package org.anowls.sys.config;

import java.util.Properties;
import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.autoconfigure.MybatisProperties;

/**
 * <p>Title: sys_platform</p>
 * <p>Description: Mybatis 配置</p>
 * <p>Copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved</p>
 * <p>Company: http://www.hanboard.com</p>
 *
 * @author haopeisong
 * @date 2018/1/26 0026
 */
@Configuration
public class MyBatisConfiguration {

    private static final String MAPPER_LOCATION = "classpath:mapper/*Mapper.xml";
    private static final String MY_BATIS_CONFIG_LOCATION = "classpath:mybatis/mybatis-config.xml";

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MAPPER_LOCATION));
        sessionFactory.setConfigLocation(
                new PathMatchingResourcePatternResolver().getResource(MY_BATIS_CONFIG_LOCATION));
        VendorDatabaseIdProvider vendorDatabaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle", "Oracle");
        properties.setProperty("MySQL", "MySQL");
        vendorDatabaseIdProvider.setProperties(properties);
        sessionFactory.setDatabaseIdProvider(vendorDatabaseIdProvider);
        return sessionFactory.getObject();
    }

    @Bean
    @Primary
    MybatisProperties mybatisProperties() {
        MybatisProperties p = new MybatisProperties();
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        p.setConfiguration(config);
        return p;
    }


}
