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
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id", nullable = false)
	private int subject_id;
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "lectures_hours", nullable = false)
	private int lectures;
	
	@Column(name = "practices_hours", nullable = false)
	private int practices;
	
	@ManyToOne
    @JoinColumn(name = "year_id", foreignKey = @ForeignKey(name="subject_year_fk"), nullable = false)
	private Year year;
	
	@ManyToOne
    @JoinColumn(name = "program_id", foreignKey = @ForeignKey(name="subject_program_fk"), nullable = false)
	private Program program;
	
	@ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name="subject_course_fk"), nullable = false)
	private Course course;
	
	@ManyToOne
    @JoinColumn(name = "semester_id", foreignKey = @ForeignKey(name="subject_semester_fk"), nullable = false)
	private Semester semester;

	public Subject() {
		super();
	}

	public Subject(int subject_id) {
		super();
		this.subject_id = subject_id;
	}

	public Subject(String title, int lectures, int practices) {
		super();
		this.title = title;
		this.lectures = lectures;
		this.practices = practices;
	}
	
	public Subject(int subject_id, String title, int lectures, int practices, Year year, Program program, Course course,
			Semester semester) {
		super();
		this.subject_id = subject_id;
		this.title = title;
		this.lectures = lectures;
		this.practices = practices;
		this.year = year;
		this.program = program;
		this.course = course;
		this.semester = semester;
	}

	public int getId() {
		return subject_id;
	}

	public void setId(int id) {
		this.subject_id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLectures() {
		return lectures;
	}

	public void setLectures(int lectures) {
		this.lectures = lectures;
	}

	public int getPractices() {
		return practices;
	}

	public void setPractices(int practices) {
		this.practices = practices;
	}
	
	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subject_id;
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
		Subject other = (Subject) obj;
		if (subject_id != other.subject_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Subject");
		return builder
			.append(" [id=").append(subject_id)
			.append(", title=").append(title)
			.append(", lectures=").append(lectures)
			.append(", practices=").append(practices)
			.append("]").toString();
	}
}