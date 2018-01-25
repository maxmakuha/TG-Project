package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.service.GroupService;
import ua.kiev.ukma.tg.service.RhythmService;

import java.security.Principal;
import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;
    
    @Autowired
    private RhythmService rhythmService;

    @RequestMapping(value = "methodist/subject/{subjectId}/groups", method = RequestMethod.GET, produces = "application/json")
    public List<Group> methodistGetAll(@PathVariable int subjectId) {
        return groupService.getSubjectGroups(subjectId);
    }
    
    @RequestMapping(value = "teacher/subject/{subjectId}/groups", method = RequestMethod.GET, produces = "application/json")
    public List<Group> teacherGetAll(@PathVariable int subjectId, Principal teacher) {
        return groupService.getTeacherGroupsBySubject(subjectId, teacher.getName());
    }

    @RequestMapping(value = "methodist/subject/{subjectId}/group", method = RequestMethod.POST, produces = "application/json")
    public Group add(@RequestBody Group group) {
        groupService.add(group);
        rhythmService.addAll(group.getId());
        return group;
    }

    @RequestMapping(value = {"methodist/subject/{subjectId}/group", "teacher/subject/{subjectId}/group"}, method = RequestMethod.PUT)
    public void update(@RequestBody Group group) {
    	groupService.update(group);
    }

    @RequestMapping(value = "methodist/subject/{subjectId}/group/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	groupService.delete(id);
    }
}