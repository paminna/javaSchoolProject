package com.example.server.utils;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.orm.hibernate3.HibernateTransactionManager;
//import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
//@EnableJpaRepositories(basePackages = "com.example.server")
//@EnableTransactionManagement
//@EnableJpaRepositories("com.example.server.*")
//@ComponentScan(basePackages = { "com.example.server.*" })
//@EntityScan("com.example.server.*")
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.example.server"})
@EnableTransactionManagement
public class Configuration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
//        factoryBean.setPersistenceUnitName("server");
//
//        return factoryBean;
//    }

//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//
//        return transactionManager;
//    }
//    @Bean
//    public DataSource dataSource() {
//
////        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
////        return builder.setType(EmbeddedDatabaseType.HSQL).build();
//        DataSourceBuilder data = DataSourceBuilder.create();
//        data.driverClassName("org.h2.Driver");
//        data.url("jdbc:h2:/Users/regina/Desktop/final_project/server/db/server");
//        data.username("admin");
//        data.password("admin");
//        return data.build();
//    }

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:test");
//        dataSourceBuilder.username("SA");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.example.server");
//        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return txManager;
//    }
}
