package com.example.demo.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableJpaRepositories(
	    basePackages = "com.example.demo.repository.emp",
	    entityManagerFactoryRef = "empEntityManager",
	    transactionManagerRef = "empTransactionManager"
)
@Profile("dev")
public class EmployeeJpaConfiguration {
	
	@Bean
	@Primary
    public LocalContainerEntityManagerFactoryBean empEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(configureEmpDataSource());
        em.setPackagesToScan(
          new String[] { "com.example.demo.entity.emp" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
         return em;
    }
	
    @Bean
    @Primary
    public PlatformTransactionManager empTransactionManager() {
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		empEntityManager().getObject());
        return transactionManager;
    }
	
    public DataSource configureEmpDataSource () {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUsername("SCOTT");
	    dataSource.setPassword("Linku6025");
	    dataSource.setUrl(
	      "jdbc:oracle:thin:localhost:1521:orcl"); 	    
	    return dataSource;
	}

	
}
