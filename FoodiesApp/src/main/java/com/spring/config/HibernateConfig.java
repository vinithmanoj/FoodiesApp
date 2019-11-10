package com.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.spring")
public class HibernateConfig {
	
//	@Autowired
//	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		Properties props = new Properties();
		// Setting JDBC properties
	      props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	      props.put("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/vinojadb?useSSL=false");
	      props.put("hibernate.connection.username", "vinoja");
	      props.put("hibernate.connection.password", "vinoja123");

	      // Setting Hibernate properties
	      props.put("hibernate.show_sql", "true");
	      props.put("hibernate.hbm2ddl.auto", "update");
	      props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

	      // Setting C3P0 properties
	      props.put("hibernate.c3p0.min_size", "1");
	      props.put("hibernate.c3p0.max_size", "20");
	      props.put("hibernate.c3p0.acquire_increment", 
	            "1");
	      props.put("hibernate.c3p0.timeout", "1800");
	      props.put("hibernate.c3p0.max_statements", "150");
	      
	      factoryBean.setHibernateProperties(props);
	      factoryBean.setPackagesToScan("com.spring.model");
	      return factoryBean;
	}
	
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
 

}
