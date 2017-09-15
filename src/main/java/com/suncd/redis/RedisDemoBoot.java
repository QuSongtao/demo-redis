package com.suncd.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.suncd.redis.dao")
@EnableTransactionManagement
public class RedisDemoBoot {

	public static void main(String[] args) {
		SpringApplication.run(RedisDemoBoot.class, args);
	}
}
