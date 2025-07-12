package go.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This is raw BookedData pojo which will object as
 * an infromation realated to bookings
 * 
 */

@Entity
@Table(name="BookingDetails")
public class BookingDetails {
	
	@Column
	@Id
	private String bookigId;
	@Column
	private String pnr;
	@Column
	private String flightId;
	@Column
	private String transectionNo;
	@Column
	private String passengerName;
	
	
	public String getBookigId() {
		return bookigId;
	}
	public void setBookigId(String bookigId) {
		this.bookigId = bookigId;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getTransectionNo() {
		return transectionNo;
	}
	public void setTransectionNo(String transectionNo) {
		this.transectionNo = transectionNo;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	 public BookingDetails() {}
	
}
