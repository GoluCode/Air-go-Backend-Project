package go.base;


import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This is raw Flight pojo which will hold information of Flight object
 * 
 */

@Entity
@Table(name="Flight")
public class Flight {
	
	@Column
	@Id
	private String flightId;
	
	@Column
	private Integer availableSeats;
	
	@Column
	private Time flyTime;
	
	@Column
	private String source;
	
	@Column
	private String destination;
	
	@Column
	private Integer fare;
	
	@Column
	private Character fclass;
	
	@Column
	private String vendor;
	
	@Column
	private Integer totalSeats;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Time getFlyTime() {
		return flyTime;
	}

	public void setFlyTime(Time flyTime) {
		this.flyTime = flyTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Character getFclass() {
		return fclass;
	}

	public void setFclass(Character fclass) {
		this.fclass = fclass;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}	
}
