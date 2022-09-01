package com.stydent.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class StudentKeyspaceConfig {

	@Value("${spring.data.cassandra.port}")
	private int port;

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keyspace;

	public int getPort() {
	return port;
	}
	public void setPort(int port) {
	this.port = port;
	}
	public String getKeyspace() {
	return keyspace;
	}
	public void setKeyspace(String keyspace) {
	this.keyspace = keyspace;
	}
}
