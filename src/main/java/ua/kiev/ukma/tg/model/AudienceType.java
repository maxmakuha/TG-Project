package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audience_types")
public class AudienceType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aud_type_id", nullable = false)
	private int aud_type_id;
	
	@Column(name = "title", nullable = false)
	private String title;

	public AudienceType() {
		super();
	}

	public AudienceType(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return aud_type_id;
	}

	public void setId(int id) {
		this.aud_type_id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aud_type_id;
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
		AudienceType other = (AudienceType) obj;
		if (aud_type_id != other.aud_type_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Audience Type");
		return builder
			.append(" [id=").append(aud_type_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}