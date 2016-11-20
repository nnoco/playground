package com.nnoco.springbook;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.nnoco.springbook.user.dao.UserDao;
import com.nnoco.springbook.user.domain.User;

public class XmlConfigClient {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FontFormatException, IOException {
		// genericXmlApplicationContext();
		 //classPathXmlApplicationContext();
		
		String parent = "/Volumes/nnoco-4th/Archive/Fonts/구름다리(otf,ttf,숨김파일)/renamed/";
		for(File file : new File("/Volumes/nnoco-4th/Archive/Fonts/구름다리(otf,ttf,숨김파일)").listFiles()) {
			if (file.getName().endsWith("otf")
					|| file.getName().endsWith("ttf")) {
				Font font = Font.createFont(Font.TRUETYPE_FONT, file);
				String extension = file.getName().substring(
						file.getName().lastIndexOf('.'));
				System.out.println(extension);
				String name = font.getFontName(Locale.KOREAN);
				Files.copy(Paths.get(file.getAbsolutePath()),
						Paths.get(parent, name + extension));
			}
		}
	}

	private static void classPathXmlApplicationContext() throws ClassNotFoundException, SQLException {
		System.out.println("========== ClassPathXmlApplicationContext =========");
		
		
		
		
		System.out.println("========== ClassPathXmlApplicationContext =========");
	}

	private static void genericXmlApplicationContext() throws ClassNotFoundException, SQLException {
		System.out.println("========== GenericXmlApplicationContext =========");
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("koltwgi" + Math.round(Math.random()*10000));
		user.setPassword("Helllo");
		user.setName("newt");
		
		dao.add(user);
		System.out.println(user.getName() + " 저장 완료!");
		user = dao.get(user.getId());
		
		System.out.println(user.getName() + " , " + user.getId() + " 가져옴!");
		System.out.println("========== GenericXmlApplicationContext =========\n");
	}
}
