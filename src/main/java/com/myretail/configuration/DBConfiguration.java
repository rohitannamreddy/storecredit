package com.myretail.configuration;
//making a change

import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class DBConfiguration {
	
	@Value("${db.user}")
	private String dbUser;
	@Value("${db.password}")
	private String dbPassword;
	@Value("${db.name}")
	private String dbName;
	@Value("${db.host}")
	private String dbHost;
	@Value("${db.port}")
	private String dbPort;
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception{
		
		MongoCredential credential = MongoCredential.createCredential(dbUser, dbName, getPassword());
		ServerAddress serverAddress = new ServerAddress(dbHost,Integer.parseInt(dbPort));
		
		MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential));
		
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient,dbName);
		
		return simpleMongoDbFactory;
	}
	
	
	public MongoTemplate mongoTemplate() throws Exception{
		return new MongoTemplate(mongoDbFactory());
	}
	
	
	private char[] getPassword(){
		
		byte[] bytePassword = Base64.decodeBase64(dbPassword.getBytes());
		String password = new String(bytePassword);
		return password.toCharArray();
		
	}
	
}
