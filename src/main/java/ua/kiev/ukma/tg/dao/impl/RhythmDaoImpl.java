package ua.kiev.ukma.tg.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.kiev.ukma.tg.dao.RhythmDao;
import ua.kiev.ukma.tg.model.Rhythm;
import ua.kiev.ukma.tg.model.Week;
import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.service.GroupService;

@Repository
public class RhythmDaoImpl implements RhythmDao {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Rhythm getById(Integer id) {
		return (Rhythm) currentSession().get(Rhythm.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rhythm> getByGroup(Integer groupId) {
		TypedQuery<Rhythm> query = currentSession().createQuery("FROM Rhythm r WHERE r.group.id = :group_id ORDER BY r.week.id");
		query.setParameter("group_id", groupId);
		return query.getResultList();
	}

	@Override
	public void add(Rhythm rhythm) {
		currentSession().save(rhythm);
	}
	
	@Override
	public void addAll(Integer groupId) {
		String semester = groupService.getById(groupId).getSubject().getSemester().getTitle();
		int quantity = "2Ä".equals(semester) ? 6 : 15; 
		for (int i = 1; i<=quantity; i++)
			currentSession().save(new Rhythm(new Week(i), new Group (groupId)));
	}

	@Override
	public void update(Rhythm rhythm) {
		currentSession().update(rhythm);
	}

	@Override
	public void delete(Integer id) {
		Rhythm rhythm = (Rhythm) currentSession().load(Rhythm.class, id);
		if (null != rhythm) {
			currentSession().delete(rhythm);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rhythm> getAll() {
		return currentSession().createQuery("FROM Rhythm").getResultList();
	}
}