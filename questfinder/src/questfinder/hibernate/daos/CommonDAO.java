package questfinder.hibernate.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import questfinder.hibernate.HibernateUtil;


public abstract class CommonDAO implements DAO {

	@Override
	public void save() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.persist(this);
			tx.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void save(Session session) {
		session.persist(this);
	}

	@Override
	public void update() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			session.update(this);
			tx.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void update(Session session) {
		session.update(this);
	}

}
