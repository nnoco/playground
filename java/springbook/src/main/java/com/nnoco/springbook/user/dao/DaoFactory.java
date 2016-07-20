package com.nnoco.springbook.user.dao;

public class DaoFactory {
	public UserDao userDao() {
//		ConnectionMaker connectionMaker = new KConnectionMaker();
		return new UserDao(connectionMaker());
	}
	
	public AccountDao accountDao() {
		// KConnectionMaker 를 생성하는 코드 중복
//		ConnectionMaker connectionMaker = new KConnectionMaker();
		return new AccountDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker() {
		return new KConnectionMaker();
	}
}
