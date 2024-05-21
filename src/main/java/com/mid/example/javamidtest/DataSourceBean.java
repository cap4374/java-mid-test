package com.mid.example.javamidtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;

import com.azure.identity.WorkloadIdentityCredentialBuilder;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Slf4j
public class DataSourceBean {    
    
	// @Value("${azure.clientId}")
	// private String clientId;

	// @Value("${azure.tenantId}")
	// private String tenatnId;

    @Bean("dataSource")
	@ConfigurationProperties("spring.datasource")
	@Primary
	public DataSource dataSource(){
		log.debug("RHYMOND::Creating datasource");

    	AzureADAuthentication azureADAuthentication = new AzureADAuthentication(
				new WorkloadIdentityCredentialBuilder()
				.clientId("4ca3d072-fa0f-4d1b-8997-fd4c3871077f")				
				.tenantId("9ec6e2d0-6c2d-4b06-b014-daca41adf2fe")
				.tokenFilePath("")
				.build());					

		String token = azureADAuthentication.getAccessToken();
		log.debug(token);

		SQLServerDataSource dataSource = new SQLServerDataSource();
		dataSource.setAccessToken(token);
		dataSource.setDatabaseName("AdventureWorksLT");		
        dataSource.setURL("jdbc:sqlserver://sql-cap-test-eus2-poc.database.windows.net:1433;database=AdventureWorksLT;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");		
        
		// dataSource.setAuthentication("ActiveDirectoryManagedIdentity");
		
		log.debug("RHYMOND::Datasource created");

		return (DataSource) dataSource;
	}
}
