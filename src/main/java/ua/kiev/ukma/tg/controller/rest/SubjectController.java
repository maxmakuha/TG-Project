package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Subject;
import ua.kiev.ukma.tg.service.SubjectService;

import java.security.Principal;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "methodist/subjects", method = RequestMethod.GET, produces = "application/json")
    public List<Subject> methodistGetAll() {
        return subjectService.getAll();
    }
    
    @RequestMapping(value = "teacher/subjects", method = RequestMethod.GET, produces = "application/json")
    public List<Subject> teacherGetAll(Principal user) {
        return subjectService.getByTeacher(user.getName());
    }

    @RequestMapping(value = "methodist/subject", method = RequestMethod.POST, produces = "application/json")
    public Subject add(@RequestBody Subject subject) {
        subjectService.add(subject);
        return subject;
    }

    @RequestMapping(value = "methodist/subject", method = RequestMethod.PUT)
    public void update(@RequestBody Subject subject) {
    	subjectService.update(subject);
    }

    @RequestMapping(value = "methodist/subject/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	subjectService.delete(id);
    }
}