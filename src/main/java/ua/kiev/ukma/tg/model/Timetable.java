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
@Table(name = "timetables")
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timetable_id", nullable = false)
	private int timetable_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@ManyToOne
    @JoinColumn(name = "year_id", foreignKey = @ForeignKey(name="timetable_year_fk"), nullable = false)
	private Year year;
	
	@ManyToOne
    @JoinColumn(name = "program_id", foreignKey = @ForeignKey(name="timetable_program_fk"), nullable = false)
	private Program program;
	
	@ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name="timetable_course_fk"), nullable = false)
	private Course course;
	
	@ManyToOne
    @JoinColumn(name = "semester_id", foreignKey = @ForeignKey(name="timetable_semester_fk"), nullable = false)
	private Semester semester;

	public Timetable() {
		super();
	}

	public Timetable(int timetable_id) {
		super();
		this.timetable_id = timetable_id;
	}

	public Timetable(int timetable_id, String title, Year year, Program program, Course course, Semester semester) {
		super();
		this.timetable_id = timetable_id;
		this.title = title;
		this.year = year;
		this.program = program;
		this.course = course;
		this.semester = semester;
	}
	
	public int getId() {
		return timetable_id;
	}

	public void setId(int timetable_id) {
		this.timetable_id = timetable_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	public String toString() {
		StringBuilder builder = new StringBuilder("Timetable");
		return builder
			.append(" [id=").append(timetable_id)
			.append(", title=").append(title)
			.append("]").toString();
	}
}