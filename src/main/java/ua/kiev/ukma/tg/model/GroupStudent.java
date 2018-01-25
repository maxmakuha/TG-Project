package ua.kiev.ukma.tg.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "concrete_students")
public class GroupStudent implements Serializable {

	@Id
	@ManyToOne
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name="concrete_student_fk"), nullable = false)
	private Student student;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name="concrete_group_fk"), nullable = false)
	private Group group;

	
	public GroupStudent() {
		super();
	}

	public GroupStudent(Student student, Group group) {
		super();
		this.student = student;
		this.group = group;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		GroupStudent other = (GroupStudent) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}	
}