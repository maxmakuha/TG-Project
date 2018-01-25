package ua.kiev.ukma.tg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "programs")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "program_id", nullable = false)
	private int program_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	public Program() {
		super();
	}

	public Program(String title) {
		super();
		this.title = title;
	}

	public Program(int program_id, String title) {
		super();
		this.program_id = program_id;
		this.title = title;
	}

	public int getId() {
		return program_id;
	}

	public void setId(int program_id) {
		this.program_id = program_id;
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
		result = prime * result + program_id;
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
		Program other = (Program) obj;
		if (program_id != other.program_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Program");
		return builder
			.append(" [id=").append(program_id)
			.append(", title=").append(title)
			.append(", type=").append(type)
			.append("]").toString();
	}
}