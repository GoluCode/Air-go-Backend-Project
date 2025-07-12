package go.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * This pojo will hold transaction ojects
 */

@Entity
@Table(name="Transactions")
public class Transactions {
	@Column
	private String flightNo;
	@Column
	@Id
	private String transectionNo;
	@Column
	private Character status;
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getTransectionNo() {
		return transectionNo;
	}
	public void setTransectionNo(String transectionNo) {
		this.transectionNo = transectionNo;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	
	public Transactions() {}
	
}
