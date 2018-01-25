package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weeks")
public class Week {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "week_id", nullable = false)
	private int week_id;
	
	@Column(name = "title", nullable = false)
	private String title;

	public Week() {
		super();
	}
	
	public Week(int week_id) {
		super();
		this.week_id = week_id;
	}

	public Week(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return week_id;
	}

	public void setId(int id) {
		this.week_id = id;
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
		result = prime * result + week_id;
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
		Week other = (Week) obj;
		if (week_id != other.week_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Week");
		return builder
			.append(" [id=").append(week_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}