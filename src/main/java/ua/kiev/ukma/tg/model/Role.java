package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private int role_id;

	@Column(name = "role", nullable = false)
	private String role;

	public Role() {
		super();
	}

	public Role(int id) {
		this.role_id = id;
	}
	
	public Role(String role) {
		this.role = role;
	}
	
	public Role(int id, String role) {
		this.role_id = id;
		this.role = role;
	}

	public int getId() {
		return role_id;
	}

	public void setId(int id) {
		this.role_id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + role_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (role_id != other.role_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Role");
		return builder
			.append(" [id=").append(role_id)
			.append(", role=").append(role)
			.append("]").toString();
	}
}