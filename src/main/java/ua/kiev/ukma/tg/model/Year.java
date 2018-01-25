package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "years")
public class Year {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "year_id", nullable = false)
	private int year_id;
	
	@Column(name = "title", nullable = false)
	private String title;

	public Year() {
		super();
	}

	public Year(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return year_id;
	}

	public void setId(int id) {
		this.year_id = id;
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
		result = prime * result + year_id;
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
		Year other = (Year) obj;
		if (year_id != other.year_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Year");
		return builder
			.append(" [id=").append(year_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}