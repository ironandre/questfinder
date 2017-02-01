package questfinder.hibernate.daos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location extends CommonDAO implements Serializable{
	private static final long serialVersionUID = 6864820445074060703L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="LNG")
	private double lng;
	@Column(name="LAT")
	private double lat;
	@Column(name="CITY")
	private String city;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="STREET")
	private String street;
	@Column(name="POSTCODE")
	private String postCode;
	@Column(name="DESCRIPTION")
	private String description;
	
	public static void main(String[] args) {
		Location l = new Location();
		l.setCity("asd");
		l.setCountry("asd");
		l.setDescription("asfasf");
		l.setLat(50.2);
		l.setLng(20.2);
		l.setPostCode("47055");
		l.setStreet("asasda");
		l.save();
	}
	
	public Location() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", lng=" + lng + ", lat=" + lat + ", city=" + city + ", country=" + country
				+ ", street=" + street + ", postCode=" + postCode + ", description=" + description + "]";
	}
	
}
