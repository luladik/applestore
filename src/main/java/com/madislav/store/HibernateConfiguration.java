package com.madislav.store;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.madislav.store"})
//@PropertySource(value = {"classpath:META-INF/application.properties"})
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.madislav.store.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    //
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//------------
//        String dbName = System.getProperty("RDS_DB_NAME");
//        String userName = System.getProperty("RDS_USERNAME");
//        String password = System.getProperty("RDS_PASSWORD");
//        String hostname = System.getProperty("RDS_HOSTNAME");
//        String port = System.getProperty("RDS_PORT");
//        String jdbcUrl = "jdbc:mysql://" + hostname + ":"
//                + port + "/" + dbName + "?user=" + userName + "&password=" + password;
//
//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//        dataSource.setUrl(jdbcUrl);
//-----------------
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://applestore.cdptnp0ck17z.eu-central-1.rds.amazonaws.com:3306/applestore");
        dataSource.setUsername("madislav123");
        dataSource.setPassword("madislav123");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}