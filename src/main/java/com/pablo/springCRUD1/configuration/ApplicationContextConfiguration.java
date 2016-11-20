package com.pablo.springCRUD1.configuration;

import com.pablo.springCRUD1.dao.*;
import com.pablo.springCRUD1.service.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Pablo on 15.11.2016.
 */
@Configuration
@ComponentScan("com.pablo.springCRUD1")
@EnableTransactionManagement
@PropertySource("ds-hibernate-cfg.properties")
public class ApplicationContextConfiguration {

    // The Environment class serves as the property holder
    // and stores all the properties loaded by the @PropertySource
    @Autowired
    private Environment env;

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource rbm = new ResourceBundleMessageSource();
        rbm.setBasenames(new String[] {"message/validator"});
        return rbm;
    }

    @Bean
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();

        managerDataSource.setDriverClassName("ds.database-driver");
        managerDataSource.setUrl("ds.Url");
        managerDataSource.setUsername("ds.username");
        managerDataSource.setPassword("ds.password");

        System.out.println("## getDataSource: " + managerDataSource);

        return managerDataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)throws Exception{

        Properties properties = new Properties();

        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("current_session_context_class", env.getProperty("current_session_context_class"));

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        factoryBean.setPackagesToScan(new String[] {"com.pablo.springCRUD1.Entity"});
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();

        SessionFactory sf = factoryBean.getObject();
        System.out.println(" ## getSessionFactory: " + sf);

        return sf;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }

    @Bean
    public AddressDAO getAddressDAO(){
        return new AddressDAOImpl();
    }

    @Bean
    public AddressService getAddressService(){
        return new AddressServiceImpl();
    }

    @Bean
    public CarDAO getCarDAO(){
        return new CarDAOImpl();
    }

    @Bean
    public CarService getCarService(){
        return new CarServiceImpl();
    }
    @Bean
    public ClientDAO getClientDAO(){
        return new ClientDAOImpl();
    }

    @Bean
    public ClientService getClientService(){
        return new ClientServiceImpl();
    }

    @Bean
    public EmployeeDAO getEmployeeDAO(){
        return new EmployeeDAOImpl();
    }

    @Bean
    public EmployeeService getEmployeeService(){
        return new EmployeeServiceImpl();
    }


}
