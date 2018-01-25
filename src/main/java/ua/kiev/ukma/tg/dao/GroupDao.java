package ua.kiev.ukma.tg.dao;

import java.util.List;

import ua.kiev.ukma.tg.model.Group;

public interface GroupDao extends Dao<Group, Integer> {
	
	List<Group> getSubjectGroups(Integer subject_id);
	List<Group> getTeacherGroups(String email);
	List<Group> getTeacherGroupsBySubject(Integer subjectId, String email);
	List<Group> getTimetableGroups (Integer timetableId);
	
}