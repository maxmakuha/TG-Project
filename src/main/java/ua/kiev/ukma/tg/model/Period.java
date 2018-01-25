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
@Table(name = "periods")
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "period_id", nullable = false)
	private int period_id;
	
	@ManyToOne
    @JoinColumn(name = "week_id", foreignKey = @ForeignKey(name="period_week_id_fk"), nullable = false)
	private Week week;
	
	@ManyToOne
    @JoinColumn(name = "day_id", foreignKey = @ForeignKey(name="period_day_id_fk"), nullable = false)
	private Day day;
	
	@ManyToOne
    @JoinColumn(name = "lesson_id", foreignKey = @ForeignKey(name="period_lesson_id_fk"), nullable = false)
	private Lesson lesson;
	
	@ManyToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name="period_group_id_fk"), nullable = false)
	private Group group;
	
	@ManyToOne
    @JoinColumn(name = "audience_id", foreignKey = @ForeignKey(name="period_audience_id_fk"), nullable = false)
	private Audience audience;
	
	@ManyToOne
    @JoinColumn(name = "timetable_id", foreignKey = @ForeignKey(name="period_timetable_id_fk"), nullable = false)
	private Timetable timetable;
	
	@Column(name = "daytime", nullable = false)
	private String daytime;
	
	@Column(name = "month", nullable = false)
	private String month;

	public Period() {
		super();
	}

	public Period(int period_id, Week week, Day day, Lesson lesson, Group group, Audience audience, Timetable timetable, String month, String daytime) {
		super();
		this.period_id = period_id;
		this.week = week;
		this.day = day;
		this.lesson = lesson;
		this.group = group;
		this.audience = audience;
		this.timetable = timetable;
		this.month = month;
		this.daytime = daytime;
	}

	public int getId() {
		return period_id;
	}

	public void setId(int period_id) {
		this.period_id = period_id;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Audience getAudience() {
		return audience;
	}

	public void setAudience(Audience audience) {
		this.audience = audience;
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	
	public String getDaytime() {
		return daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Period");
		return builder
			.append(" [id=").append(period_id)
			.append("]").toString();
	}
}