package com.example.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
	    basePackages = "com.example.demo.repository.policy",
	    entityManagerFactoryRef = "policyEntityManager",
	    transactionManagerRef = "policyTransactionManager"
)
@Profile("dev")
public class PolicyJpaConfiguration {
	
	@Bean
    public LocalContainerEntityManagerFactoryBean policyEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(configureHrDataSource());
        em.setPackagesToScan(
          new String[] { "com.example.demo.entity.policy" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }
	
	@Bean
    public PlatformTransactionManager policyTransactionManager() { 
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		policyEntityManager().getObject());
        return transactionManager;
    }
	
	public DataSource configureHrDataSource () {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUsername("HR");
	    dataSource.setPassword("Linku6025");
	    dataSource.setUrl(
	      "jdbc:oracle:thin:localhost:1521:orcl"); 	    
	    return dataSource;
	}
	
}
