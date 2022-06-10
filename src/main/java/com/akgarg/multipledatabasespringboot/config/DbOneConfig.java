package com.akgarg.multipledatabasespringboot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 10-06-2022
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "dbOneEntityManagerFactory",
        transactionManagerRef = "dbOneTransactionManager",
        basePackages = "com.akgarg.multipledatabasespringboot.dbone.repository"
)
public class DbOneConfig {

    @Bean("dbOneDataSource")
    @ConfigurationProperties(prefix = "multidbone.datasource")
    @Primary
    public DataSource dbOneDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dbOneEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean dbOneEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dbOneDataSource") DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return builder.dataSource(dataSource)
                .packages("com.akgarg.multipledatabasespringboot.dbone.entity")
                .properties(properties)
                .build();
    }

    @Bean("dbOneTransactionManager")
    @Primary
    public PlatformTransactionManager dbOneTransactionManager(@Qualifier("dbOneEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
