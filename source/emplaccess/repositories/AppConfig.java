
package com.emplaccess.repositories;


import com.emplaccess.bean.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Properties;


 ////Created by JDCOM on 11/10/2016.


@Configuration
@ComponentScan(basePackages = "com.emplaccess")
@EnableWebMvc
@EnableJpaRepositories
@EnableTransactionManagement

public class AppConfig {
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Constants.driver);
        dataSource.setUrl(Constants.url);
        dataSource.setUsername(Constants.username);
        dataSource.setPassword(Constants.password);

        System.out.println(Constants.driver+Constants.url+Constants.username+Constants.password);
        return dataSource;
    }
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
                LocalContainerEntityManagerFactoryBean();


        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.emplaccess");
        Properties jpaProperties =new Properties();
        jpaProperties.put("hibernate.dialect",Constants.hibernatedialect);
        jpaProperties.put("hibernate.hbm2ddl.auto",Constants.hibernatehbm2ddlauto);
        jpaProperties.put("hibernate.show_sql",Constants.hibernateshow_sql);
        jpaProperties.put("hibernate.format_sql",Constants.hibernateformat_sql);


        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        System.out.println("in am in LocalContainerEntityManagerFactoryBean");
        return  new JpaTransactionManager();}

    @Bean

    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;}

}
