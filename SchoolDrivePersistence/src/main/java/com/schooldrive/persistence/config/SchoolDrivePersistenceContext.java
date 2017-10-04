package com.schooldrive.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Filip on 21.09.2017.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.schooldrive.persistence")
public class SchoolDrivePersistenceContext {

    @Bean
    public String getDbDialect() {

        return "org.hibernate.dialect.MySQLInnoDBDialect";
    }

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName("com.mysql.jdbc.Driver");
        dm.setUrl("jdbc:mysql://localhost:3306/driving_school?useUnicode=yes&characterEncoding=UTF-8");
        dm.setUsername("root");
        dm.setPassword("");

        return dm;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setJpaVendorAdapter(getJpaVendorAdapter());

        return em;
    }

    @Bean
    public JpaTransactionManager getEntityManager() {

        JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(getEntityManagerFactory().getObject());

        return jtm;
    }

    @Bean
    public HibernateJpaVendorAdapter getJpaVendorAdapter() {

        HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setDatabasePlatform(getDbDialect());

        return hjva;
    }
}
