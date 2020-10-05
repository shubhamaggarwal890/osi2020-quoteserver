package com.example.osi2020.osi2020quoteserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Osi2020quoteserverApplication {

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		String database_host = System.getenv("DATABASE_HOST");
		String database_port = System.getenv("DATABASE_PORT");
		String database = System.getenv("MYSQL_DATABASE");
		String user = System.getenv("MYSQL_USER");
		String password = System.getenv("MYSQL_PASSWORD");
		if(database_host !=null){
			dataSourceBuilder.url("jdbc:mysql://"+database_host+":"+database_port+"/"+database);
			dataSourceBuilder.username(user);
			dataSourceBuilder.password(password);
		}else{
			dataSourceBuilder.url("jdbc:mysql://localhost:3306/osi2020");
			dataSourceBuilder.username("osi2020");
			dataSourceBuilder.password("osi2020");

		}
		return dataSourceBuilder.build();
	}


	public static void main(String[] args) {
		SpringApplication.run(Osi2020quoteserverApplication.class, args);
	}

}
