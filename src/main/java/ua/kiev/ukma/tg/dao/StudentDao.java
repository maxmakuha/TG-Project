package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.GroupStudent;
import ua.kiev.ukma.tg.model.Student;

public interface StudentDao extends Dao<Student, Integer> {
	
	void addToGroup(GroupStudent student);
	void deleteFromGroup(GroupStudent student);
	List<GroupStudent> getStudentsByGroup(Integer id);
	List<Student> getOtherStudents(Integer group_id);

}