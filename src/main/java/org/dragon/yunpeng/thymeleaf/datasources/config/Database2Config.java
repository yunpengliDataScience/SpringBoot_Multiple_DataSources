package org.dragon.yunpeng.thymeleaf.datasources.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory2", transactionManagerRef = "transactionManager2", basePackages = {
		"org.dragon.yunpeng.thymeleaf.datasource2.repositories" })
public class Database2Config {

	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "entityManagerFactory2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory2(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource2") DataSource dataSource2) {
		return builder.dataSource(dataSource2).packages("org.dragon.yunpeng.thymeleaf.datasource2.entities")
				.persistenceUnit("datasource2").build();
	}

	@Bean(name = "transactionManager2")
	public PlatformTransactionManager transactionManager2(
			@Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory2) {
		return new JpaTransactionManager(entityManagerFactory2);
	}
}
