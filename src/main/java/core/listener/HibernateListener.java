package core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//import static core.util.HibernateUtil.*;

// 管理連線工廠
// 交給 AppConfig.class 的 @Bean裡面託管了
//@WebListener
public class HibernateListener implements ServletContextListener {

//	@Override
//	public void contextInitialized(ServletContextEvent sce) {
//		getSessionFactory();
//	}
//
//	@Override
//	public void contextDestroyed(ServletContextEvent sce) {
//		shutdown();
//	}
}
