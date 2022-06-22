package vegan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity 
@Table(name="reserve") 
@Component
public class Reserve {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reserveId; 
	@Column(name = "reserveName")
	private String reserveName;
	@Column(name = "reserveDate")
	private String reserveDate;
	@Column(name = "reserveRestuarant")
	private String reserveRestuarant;
	
	public Reserve() {}
	
	public Reserve(Integer reserveId, String reserveName, String reserveDate, String reserveRestuarant) {
		this.reserveId = reserveId;
		this.reserveName = reserveName;
		this.reserveDate = reserveDate;
		this.reserveRestuarant = reserveRestuarant;
	}

	public Reserve(String reserveName, String reserveDate, String reserveRestuarant) {
		this.reserveName = reserveName;
		this.reserveDate = reserveDate;
		this.reserveRestuarant = reserveRestuarant;
	}

	public Integer getReserveId() {
		return reserveId;
	}

	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}

	public String getReserveName() {
		return reserveName;
	}

	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getReserveRestuarant() {
		return reserveRestuarant;
	}

	public void setReserveRestuarant(String reserveRestuarant) {
		this.reserveRestuarant = reserveRestuarant;
	}
	
	
	
	
	
}
