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
@Table(name = "audiences")
public class Audience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "audience_id", nullable = false)
	private int audience_id;
	
	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "size", nullable = false)
	private int size;
	
	@ManyToOne
    @JoinColumn(name = "aud_type_id", foreignKey = @ForeignKey(name="aud_type_fk"), nullable = false)
	private AudienceType type;

	public Audience() {
		super();
	}

	public Audience(int audience_id) {
		super();
		this.audience_id = audience_id;
	}

	public Audience(String number, int size) {
		super();
		this.number = number;
		this.size = size;
	}

	public int getId() {
		return audience_id;
	}

	public void setId(int id) {
		this.audience_id = id;
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

	public AudienceType getType() {
		return type;
	}

	public void setType(AudienceType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + audience_id;
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
		Audience other = (Audience) obj;
		if (audience_id != other.audience_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Audience");
		return builder
			.append(" [id=").append(audience_id)
			.append(", number=").append(number)
			.append(", size=").append(size)
			.append(", type_id=").append(type.getId())
			.append(", type=").append(type.getTitle())
			.append("]").toString();
	}
}