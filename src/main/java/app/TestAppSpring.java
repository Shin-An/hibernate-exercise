package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import web.member.dao.MemberDao;
import web.member.entity.Member;

public class TestAppSpring {
	
	public static void main(String[] args) {
		// IoC/DI config 設定
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MemberDao memberDao = applicationContext.getBean(MemberDao.class);
//
//		for (Member member : memberDao.selectAll()) {
//			System.out.println(member.getNickname());
//		}
		
		// 練習拿回DataSource
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM member WHERE id = ?");
		){	
			pstmt.setInt(1, 2);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					System.out.println(rs.getString("nickname"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 練習拿回memberDao
//		GenericApplicationContext applicationContext = new GenericApplicationContext();
//        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("applicationContext.xml");
//        applicationContext.refresh();
//        
//        MemberDao memberDao = applicationContext.getBean(MemberDao.class);
//        System.out.println(memberDao.selectById(1).getNickname());
//            
//        ((ConfigurableApplicationContext) applicationContext).close();
		
	}
}
