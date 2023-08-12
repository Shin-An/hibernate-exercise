package core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import static core.util.HibernateUtil.getSessionFactory;

// 此段內容託管給 Spring 了，因此不需要了

public interface CoreService {

//	private Session getSession() {
//		return getSessionFactory().getCurrentSession();
//	}
//
//	default Transaction beginTransaction() {
//		return getSession().beginTransaction();
//	}
//
//	default void commit() {
//		getSession().getTransaction().commit();
//	}
//
//	default void rollback() {
//		getSession().getTransaction().rollback();
//	}

}
