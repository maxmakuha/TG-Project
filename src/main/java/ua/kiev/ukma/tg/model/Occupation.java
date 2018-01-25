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
@Table(name = "occupations")
public class Occupation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "occupation_id", nullable = false)
	private int occupation_id;
	
	@Column(name = "comment", nullable = false)
	private String comment;
	
	@ManyToOne
    @JoinColumn(name = "day_id", foreignKey = @ForeignKey(name="occupation_day_id_fk"), nullable = false)
	private Day day;
	
	@ManyToOne
    @JoinColumn(name = "lesson_id", foreignKey = @ForeignKey(name="occupation_lesson_id_fk"), nullable = false)
	private Lesson lesson;
	
	@ManyToOne
    @JoinColumn(name = "audience_id", foreignKey = @ForeignKey(name="occupation_audience_id_fk"), nullable = false)
	private Audience audience;

	public Occupation() {
		super();
	}

	public Occupation(int occupation_id, String comment, Day day, Lesson lesson, Audience audience) {
		super();
		this.occupation_id = occupation_id;
		this.comment = comment;
		this.day = day;
		this.lesson = lesson;
		this.audience = audience;
	}

	public int getId() {
		return occupation_id;
	}

	public void setId(int occupation_id) {
		this.occupation_id = occupation_id;
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

	public Audience getAudience() {
		return audience;
	}

	public void setAdience(Audience audience) {
		this.audience = audience;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + occupation_id;
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
		Occupation other = (Occupation) obj;
		if (occupation_id != other.occupation_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Occupation");
		return builder
			.append(" [id=").append(occupation_id)
			.append(", comment=").append(comment)
			.append("]").toString();
	}
}