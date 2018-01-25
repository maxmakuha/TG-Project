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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", nullable = false)
	private int student_id;
	
	@ManyToOne
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name="student_user_fk"), nullable = false)
	private User user;

	@ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name="student_course_fk"), nullable = false)
	private Course course;

	@ManyToOne
    @JoinColumn(name = "program_id", foreignKey = @ForeignKey(name="student_program_fk"), nullable = false)
	private Program program;

	public Student() {
		super();
	}

	public Student(int student_id) {
		super();
		this.student_id = student_id;
	}

	public Student(int student_id, User user, Course course, Program program) {
		super();
		this.student_id = student_id;
		this.user = user;
		this.course = course;
		this.program = program;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + student_id;
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
		Student other = (Student) obj;
		if (student_id != other.student_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Student");
		return builder
			.append(" [id=").append(student_id)
			.append(", name=").append(user.getName())
			.append(", course=").append(course.getTitle())
			.append(", program=").append(program.getTitle())
			.append("]").toString();
	}
}