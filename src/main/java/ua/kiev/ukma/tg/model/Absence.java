package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "absences")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "absence_id", nullable = false)
	private int absence_id;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@ManyToOne
    @JoinColumn(name = "day_id", foreignKey = @ForeignKey(name="absence_day_id_fk"), nullable = false)
	private Day day;
	
	@ManyToOne
    @JoinColumn(name = "lesson_id", foreignKey = @ForeignKey(name="absence_lesson_id_fk"), nullable = false)
	private Lesson lesson;
	
	@ManyToOne
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name="absence_teacher_id_fk"), nullable = false)
	private User teacher;

	public Absence() {
		super();
	}

	public Absence(int absence_id, String comment, Day day, Lesson lesson, User teacher) {
		super();
		this.absence_id = absence_id;
		this.comment = comment;
		this.day = day;
		this.lesson = lesson;
		this.teacher = teacher;
	}

	public int getId() {
		return absence_id;
	}

	public void setId(int absence_id) {
		this.absence_id = absence_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + absence_id;
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
		Absence other = (Absence) obj;
		if (absence_id != other.absence_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Absence");
		return builder
			.append(" [id=").append(absence_id)
			.append(", comment=").append(comment)
			.append("]").toString();
	}
}