package questfinder.hibernate.daos;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import questfinder.hibernate.HibernateUtil;

@ManagedBean
@Entity(name="user")
@Table(name="user")
public class User extends CommonDAO{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	int id;
	@Column(name="FNAME")
	String fName;
	@Column(name="LNAME")
	String lName;
	@Column(name="RATING")
	double rating;
	@Column(name="EXP")
	int exp; 
	@Column(name="PASSWORD")
	String password;
	@Column(name="EMAIL")
	String eMail;
	@Column(name="GENDER")
	private String gender;
	@Column(name="BIRTH_DATE")
	private Date bday;
	@Column(name="NICK")
	private String nick;
	@Column(name="DISPLAY_PIC")
	private byte[] pic;
	@OneToOne
	@JoinColumn(name="HOME_LOCATION_ID")
	Location homeLocation;
	@Column(name="OPTION_ID")
	int option;
	
	public User() {
		homeLocation = new Location();
	}

	
	
	@Override
	public void save() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			homeLocation.save(session);
			super.save(session);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", rating=" + rating + ", exp=" + exp
				+ ", password=" + password + ", eMail=" + eMail + ", homeLocation=" + homeLocation + ", option="
				+ option + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Location getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(Location homeLocation) {
		if(homeLocation == null) {
			this.homeLocation = new Location();
		} else {
			this.homeLocation = homeLocation;	
		}
		
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}
	
//	TEST
	public static void main(String[] args) {
		User user = HibernateUtil.getObjectByID(User.class, 1);
		System.out.println(user);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
}
