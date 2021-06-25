package org.hillel.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.dialect.PostgreSQL10Dialect;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
@PropertySource("classpath:/config/database.properties")
@ComponentScan({"org.hillel.persistence", "org.hillel.service", "org.hillel.controller.converter"})
@EnableJpaRepositories(entityManagerFactoryRef = "emf", basePackages = {"org.hillel.persistence.jpa.repository"})
@EnableTransactionManagement
public class RootConfig {

    private final long connTimeOut = 300;
    private final int poolSize = 150;
    private final int minIdle = 30;

    @Bean
    public DataSource dataSource(
            @Value("${database.username}") String userName,
            @Value("${database.password}") String password,
            @Value("${database.url}") String url,
            @Value("${database.name}") String databaseName
    ) {
        HikariConfig config = new HikariConfig();
        config.setPassword(password);
        config.setUsername(userName);
        config.setJdbcUrl(url);
        config.addDataSourceProperty("databaseName", databaseName);
        config.setDataSourceClassName(PGSimpleDataSource.class.getName());
        config.setConnectionTimeout(SECONDS.toMillis(connTimeOut));
        config.setMinimumIdle(minIdle);
        config.setMaximumPoolSize(poolSize);
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf(
            DataSource dataSource,
            @Value("${hibernate.hbm2ddl}") String hbm2ddl,
            @Value("${hibernate.show_sql}") String showSql,
            @Value("${hibernate.query.timeout}") int timeout
    ) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("org.hillel.persistence.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("hibernate.dialect", PostgreSQL10Dialect.class.getName());
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.put("hibernate.show_sql", showSql);
        properties.put("javax.persistence.query.timout", timeout);
        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory,
            DataSource dataSource
    ) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        jpaTransactionManager.setDataSource(dataSource);
        return jpaTransactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
