package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "days")
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "day_id", nullable = false)
	private int day_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	public Day() {
		super();
	}
	
	public Day(int day_id) {
		super();
		this.day_id = day_id;
	}

	public Day(String title) {
		super();
		this.title = title;
	}

	public Day(int day_id, String title) {
		super();
		this.day_id = day_id;
		this.title = title;
	}

	public int getId() {
		return day_id;
	}

	public void setId(int day_id) {
		this.day_id = day_id;
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
		result = prime * result + day_id;
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
		Day other = (Day) obj;
		if (day_id != other.day_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Day");
		return builder
			.append(" [id=").append(day_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}