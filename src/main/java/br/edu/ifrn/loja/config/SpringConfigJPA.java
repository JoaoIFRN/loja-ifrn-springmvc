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
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
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
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/loja-ifrn");
        ds.setUsername("postgres");
        ds.setPassword("scada2005");
        /*
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/loja-ifrn");
        ds.setUsername("root");
        ds.setPassword("");
        */
        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource ds) {
        LocalContainerEntityManagerFactoryBean lc
                = new LocalContainerEntityManagerFactoryBean();
        lc.setDataSource(ds);
        lc.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        lc.setPackagesToScan("br.edu.ifrn.loja.model");
        lc.setJpaProperties(properties());
        return lc.getObject();
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

}
