package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lesson_id", nullable = false)
	private int lesson_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	public Lesson() {
		super();
	}

	public Lesson(int lesson_id) {
		super();
		this.lesson_id = lesson_id;
	}

	public Lesson(String title) {
		super();
		this.title = title;
	}

	public Lesson(int lesson_id, String title) {
		super();
		this.lesson_id = lesson_id;
		this.title = title;
	}

	public int getId() {
		return lesson_id;
	}

	public void setId(int lesson_id) {
		this.lesson_id = lesson_id;
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
		result = prime * result + lesson_id;
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
		Lesson other = (Lesson) obj;
		if (lesson_id != other.lesson_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Lesson");
		return builder
			.append(" [id=").append(lesson_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}