package questfinder.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import questfinder.spring.SpringUtil;
import questfinder.tools.ClassCastUtil;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		LocalSessionFactoryBean sfBean = (LocalSessionFactoryBean) SpringUtil.getApplicationContext()
				.getBean(LocalSessionFactoryBean.class);
		sessionFactory = sfBean.getObject();
		
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void plainPersist(Object obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(obj);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	public static void Persist(Object obj) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(obj);
			tx.commit();
		} finally {
			session.close();
		}
	}
	
	public static <T> List<T> listAll(Class<T> t, String hql) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<T> resultList = ClassCastUtil.castList(t, session.createQuery(hql).getResultList());
		session.close();
		return resultList;
	}
	
	public static boolean checkIfValueExistByHQL(String hql) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			List resultList = session.createQuery(hql).getResultList();
			for(Object obj : resultList) {
				if(obj!=null) {
					return true;
				}
			}
			return false;
		} finally {
			session.close();
		}
	}
	
	
	public static <T> T getObjectByID(Class<T> t, int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		T retObj = session.get(t, id);
		tx.commit();
		return retObj;
	}
}