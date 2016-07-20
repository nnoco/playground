package com.nnoco.springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nnoco.springbook.user.domain.User;

public class UserDaoTest {
	public static void main( String[] args ) throws ClassNotFoundException, SQLException {
		// Spring 적용 - Application Context 활용
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		daoTest(dao, "nnoco9", "이준영", "Hello");
		
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println(ccm.getCounter());
    }
	
	static void daoTest(UserDao userDao, String id, String name, String password) throws ClassNotFoundException, SQLException {
		User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        
        userDao.add(user);
        
        System.out.println(user.getId() + " 등록 성공");
        
        User user2 = userDao.get(id);
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
	}
}
