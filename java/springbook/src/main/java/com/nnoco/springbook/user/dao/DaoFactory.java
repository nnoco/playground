package com.nnoco.springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {
//		ConnectionMaker connectionMaker = new KConnectionMaker();
		return new UserDao(connectionMaker());
	}
	
	@Bean
	public AccountDao accountDao() {
		// KConnectionMaker 를 생성하는 코드 중복
//		ConnectionMaker connectionMaker = new KConnectionMaker();
		return new AccountDao(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new KConnectionMaker();
	}
}
