package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group_types")
public class GroupType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_type_id", nullable = false)
	private int group_type_id;
	
	@Column(name = "title", nullable = false)
	private String title;

	public GroupType() {
		super();
	}

	public GroupType(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return group_type_id;
	}

	public void setId(int id) {
		this.group_type_id = id;
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
		result = prime * result + group_type_id;
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
		GroupType other = (GroupType) obj;
		if (group_type_id != other.group_type_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Group Type");
		return builder
			.append(" [id=").append(group_type_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}