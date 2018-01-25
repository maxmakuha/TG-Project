package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Absence;
import ua.kiev.ukma.tg.service.AbsenceService;
import ua.kiev.ukma.tg.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "teacher/absences", method = RequestMethod.GET, produces = "application/json")
    public List<Absence> getTeacherAbsences(Principal user) {
        return absenceService.getByTeacher(user.getName());
    }
    
    @RequestMapping(value = "methodist/teacher/{teacherId}/absences", method = RequestMethod.GET, produces = "application/json")
    public List<Absence> methodistGetTeacherAbsences(@PathVariable int teacherId) {
        return absenceService.getByTeacher(userService.getById(teacherId).getEmail());
    }

    @RequestMapping(value = "teacher/absence", method = RequestMethod.POST, produces = "application/json")
    public Absence add(@RequestBody Absence absence) {
    	absenceService.add(absence);
        return absence;
    }

    @RequestMapping(value = "teacher/absence", method = RequestMethod.PUT)
    public void update(@RequestBody Absence absence) {
    	absenceService.update(absence);
    }

    @RequestMapping(value = "teacher/absence/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	absenceService.delete(id);
    }
}