package questfinder.hibernate.daos;

import org.hibernate.Session;

public interface DAO {
	public void save();
	public void save(Session session);
	public void update();
	public void update(Session session);
}
