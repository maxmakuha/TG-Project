package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.GroupDao;
import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.service.GroupService;

@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Override
	public Group getById(Integer id) {
		return groupDao.getById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		groupDao.delete(id);
	}

	@Override
	public List<Group> getAll() {
		return groupDao.getAll();
	}

	@Override
	public List<Group> getTimetableGroups(Integer timetableId) {
		return groupDao.getTimetableGroups(timetableId);
	}

	@Override
	public List<Group> getSubjectGroups(Integer subject_id) {
		return groupDao.getSubjectGroups(subject_id);
	}

	@Override
	public List<Group> getTeacherGroups(String email) {
		return groupDao.getTeacherGroups(email);
	}

	@Override
	public List<Group> getTeacherGroupsBySubject(Integer subjectId, String email) {
		return groupDao.getTeacherGroupsBySubject(subjectId, email);
	}
}