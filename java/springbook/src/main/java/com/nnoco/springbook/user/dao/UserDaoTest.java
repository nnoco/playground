package com.nnoco.springbook.user.dao;

import java.sql.SQLException;

import com.nnoco.springbook.user.domain.User;

public class UserDaoTest {
	public static void main( String[] args ) throws ClassNotFoundException, SQLException {
		ConnectionMaker connectionMaker = new KConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);
        
        User user = new User();
        user.setId("nnoco56");
        user.setName("이준영");
        user.setPassword("hello");
        
        dao.add(user);
        
        System.out.println(user.getId() + " 등록 성공");
        
        User user2 = dao.get("nnoco4");
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}
