/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author joaon
 */
@Configuration
public class SpringConfigMVC {
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver in = new InternalResourceViewResolver();
        in.setPrefix("/WEB-INF/views/");
        in.setSuffix(".jsp");
        return in;
    }
    
}
