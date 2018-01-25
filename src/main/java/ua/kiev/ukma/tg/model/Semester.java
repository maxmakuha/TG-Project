package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "semesters")
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semester_id", nullable = false)
	private int semester_id;
	
	@Column(name = "title", nullable = false)
	private String title;

	public Semester() {
		super();
	}

	public Semester(String title) {
		super();
		this.title = title;
	}

	public int getId() {
		return semester_id;
	}

	public void setId(int id) {
		this.semester_id = id;
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
		result = prime * result + semester_id;
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
		Semester other = (Semester) obj;
		if (semester_id != other.semester_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Semester");
		return builder
			.append(" [id=").append(semester_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}