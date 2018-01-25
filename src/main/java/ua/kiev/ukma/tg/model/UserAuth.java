package ua.kiev.ukma.tg.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class UserAuth implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private int user_id;

	@Column(name = "email", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name="role_fk"), nullable = false)
	private Role role;

	public UserAuth() {
		super();
	}

	public UserAuth(int id, String username, String password, Role role) {
		this.user_id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return user_id;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role.getRole()));
	}

	@Override
	public String toString() {
		return "UserAuth [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
}