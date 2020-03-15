package com.hcl.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	@Autowired
	DataSource dataSource;
	 @Bean
	 @Primary
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource);
	        sessionFactory.setPackagesToScan(new String[] { "com.hcl.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	     
	     @Bean
	    public  Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.hbm2ddl.auto", "update");
	        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        properties.setProperty("hibernate.show_sql", "true");
	        return properties;        
	    }
	     
	     @Bean
	     public PlatformTransactionManager hibernateTransactionManager() {
	    	 HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    	 transactionManager.setSessionFactory(sessionFactory().getObject());
	    	 return transactionManager;
	     }
	     
}
