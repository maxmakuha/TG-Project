package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", nullable = false)
	private int course_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	public Course() {
		super();
	}

	public Course(String title) {
		super();
		this.title = title;
	}

	public Course(int course_id, String title) {
		super();
		this.course_id = course_id;
		this.title = title;
	}

	public int getId() {
		return course_id;
	}

	public void setId(int course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course_id;
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
		Course other = (Course) obj;
		if (course_id != other.course_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Course");
		return builder
			.append(" [id=").append(course_id)
			.append(", title=").append(title)
			.append(", type=").append(type)
			.append("]").toString();
	}
}