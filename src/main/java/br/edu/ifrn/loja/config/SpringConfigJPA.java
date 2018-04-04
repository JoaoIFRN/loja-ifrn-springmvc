/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author joaon
 */
@Configuration
@EnableTransactionManagement
public class SpringConfigJPA {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();       
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/loja-ifrn");
        ds.setUsername("root");
        ds.setPassword("");
        
        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource ds) {
        LocalContainerEntityManagerFactoryBean lc
                = new LocalContainerEntityManagerFactoryBean();
        lc.setDataSource(ds);
        lc.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        lc.setPackagesToScan("br.edu.ifrn.loja.model","br.edu.ifrn.loja.dao");
        lc.setJpaProperties(properties());
        lc.afterPropertiesSet();
        return lc.getObject();
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setEntityManagerFactory(factory);
        tx.setJpaDialect(new HibernateJpaDialect());
        return tx;
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

}
