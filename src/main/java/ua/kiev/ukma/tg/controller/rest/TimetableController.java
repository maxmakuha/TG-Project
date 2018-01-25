package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Timetable;
import ua.kiev.ukma.tg.service.TimetableService;

import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @RequestMapping(value = "methodist/timetables", method = RequestMethod.GET, produces = "application/json")
    public List<Timetable> methodistGetAll() {
        return timetableService.getAll();
    }
    
    @RequestMapping(value = "teacher/timetables", method = RequestMethod.GET, produces = "application/json")
    public List<Timetable> teacherGetAll() {
        return timetableService.getAll();
    }
    
    @RequestMapping(value = "student/timetables", method = RequestMethod.GET, produces = "application/json")
    public List<Timetable> studentGetAll() {
        return timetableService.getAll();
    }

    @RequestMapping(value = "methodist/timetable", method = RequestMethod.POST, produces = "application/json")
    public Timetable add(@RequestBody Timetable timetable) {
        timetableService.add(timetable);
        return timetable;
    }

    @RequestMapping(value = "methodist/timetable", method = RequestMethod.PUT)
    public void update(@RequestBody Timetable timetable) {
    	timetableService.update(timetable);
    }

    @RequestMapping(value = "methodist/timetable/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	timetableService.delete(id);
    }
}