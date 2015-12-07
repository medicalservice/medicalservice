package com.licorice.test;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionTest {
	@Bean      
	 public IService service() {          
		 // configure and return a class having @Transactional methods          
		 return new ServiceImpl(sessionFactory());      
	}       
	 @Bean      
	 public DataSource dataSource() {          
		 DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
		 dataSource.setUrl("jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true");
		 dataSource.setUsername("root");
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 
		 return dataSource;
	} 
	 
	 @Bean      
	 public PlatformTransactionManager txManager() {          
		 return new HibernateTransactionManager(sessionFactory());      
	}
	 
	 @Bean 
	 public LocalSessionFactoryBean sessionFactoryBean() {
		 LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		 sessionFactoryBean.setDataSource(dataSource());
		
		 return sessionFactoryBean;
	 }
	 
	 private SessionFactory sessionFactory() {
		 return sessionFactoryBean().getObject();
	 }
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(TransactionTest.class);
		IService foo = context.getBean(IService.class);
		foo.save();
	}
}
