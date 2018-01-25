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
@Table(name = "rhythms")
public class Rhythm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rhythm_id", nullable = false)
	private int rhythm_id;
	
	@ManyToOne
    @JoinColumn(name = "week_id", foreignKey = @ForeignKey(name="rhythm_week_id_fk"), nullable = false)
	private Week week;
	
	@ManyToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name="rhythm_group_id_fk"), nullable = false)
	private Group group;

	public Rhythm() {
		super();
	}

	public Rhythm(Week week, Group group) {
		super();
		this.week = week;
		this.group = group;
	}

	public Rhythm(int rhythm_id, Week week, Group group) {
		super();
		this.rhythm_id = rhythm_id;
		this.week = week;
		this.group = group;
	}

	public int getId() {
		return rhythm_id;
	}

	public void setId(int rhythm_id) {
		this.rhythm_id = rhythm_id;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
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
		result = prime * result + rhythm_id;
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
		Rhythm other = (Rhythm) obj;
		if (rhythm_id != other.rhythm_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Rhythm");
		return builder
			.append(" [id=").append(rhythm_id)
			.append("]").toString();
	}
}