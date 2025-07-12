package go.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This is the base users Pojo Where user can be Admin,Manager or random User
 * these are the entity who are going to use this Application .
 * 
 */

@Entity
@Table(name = "Users")
public class Users {

	@Column
	private String username;
	@Column
	private String name;
	
	@Column
	@Id
	private String userId;
	@Column
	private String password;
	@Column
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users() {
	};

}
