package ua.kiev.ukma.tg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.ukma.tg.dao.StudentDao;
import ua.kiev.ukma.tg.model.GroupStudent;
import ua.kiev.ukma.tg.model.Student;
import ua.kiev.ukma.tg.service.StudentService;
import ua.kiev.ukma.tg.service.UserService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Student getById(Integer id) {
		return studentDao.getById(id);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void add(Student student) {
		userService.addStudent(student.getUser());
		studentDao.add(student);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addToGroup(GroupStudent student) {
		studentDao.addToGroup(student);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void delete(Integer id) {
		studentDao.delete(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void deleteFromGroup(GroupStudent student) {
		studentDao.deleteFromGroup(student);
	}
	
	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}
	
	@Override
	public List<Student> getOtherStudents(Integer group_id) {
		return studentDao.getOtherStudents(group_id);
	}
	
	@Override
	public List<GroupStudent> getStudentsByGroup(Integer id) {
		return studentDao.getStudentsByGroup(id);
	}
}