//package com.example.demo.configurarion;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration  @Profile("test")
//@EnableJpaRepositories(
//	    basePackages = "com.example.demo.repository",
//	    entityManagerFactoryRef = "empEntityManager",
//	    transactionManagerRef = "empTransactionManager"
//)
//public class TestDataSourcesConfiguration {
//	
//	@Bean
//	@Primary
//    public LocalContainerEntityManagerFactoryBean empEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//          = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(
//          new String[] { "com.example.demo.entity" });
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//         return em;
//    }
//	
//    @Bean
//    @Primary
//    public PlatformTransactionManager empTransactionManager() {
//        JpaTransactionManager transactionManager
//          = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//        		empEntityManager().getObject());
//        return transactionManager;
//    }
//	
//	
//	public DataSource dataSource () {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//        return dataSource;
//	}
//	
//		
//}
