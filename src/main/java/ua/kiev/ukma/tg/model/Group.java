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
@Table(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", nullable = false)
	private int group_id;
	
	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "size", nullable = false)
	private int size;
	
	@ManyToOne
    @JoinColumn(name = "group_type_id", foreignKey = @ForeignKey(name="group_type_id_fk"), nullable = false)
	private GroupType type;
	
	@ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name="group_teacher_id_fk"), nullable = false)
	private User teacher;
	
	@ManyToOne
    @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name="group_subject_id_fk"), nullable = false)
	private Subject subject;
	
	@ManyToOne
    @JoinColumn(name = "aud_type_id", foreignKey = @ForeignKey(name="group_aud_type_fk"), nullable = false)
	private AudienceType audienceType;

	public Group() {
		super();
	}

	public Group(int group_id) {
		super();
		this.group_id = group_id;
	}

	public Group(String number, int size) {
		super();
		this.number = number;
		this.size = size;
	}

	public Group(int group_id, String number, int size, GroupType type, User teacher, Subject subject, AudienceType audType) {
		super();
		this.group_id = group_id;
		this.number = number;
		this.size = size;
		this.type = type;
		this.teacher = teacher;
		this.subject = subject;
		this.audienceType = audType;
	}

	public int getId() {
		return group_id;
	}

	public void setId(int id) {
		this.group_id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public GroupType getType() {
		return type;
	}

	public void setType(GroupType type) {
		this.type = type;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public AudienceType getAudienceType() {
		return audienceType;
	}

	public void setAudienceType(AudienceType audienceType) {
		this.audienceType = audienceType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + group_id;
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
		Group other = (Group) obj;
		if (group_id != other.group_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Group");
		return builder
			.append(" [id=").append(group_id)
			.append(", number=").append(number)
			.append(", size=").append(size)
			.append(", type_id=").append(type.getId())
			.append(", type=").append(type.getTitle())
			.append("]").toString();
	}
}