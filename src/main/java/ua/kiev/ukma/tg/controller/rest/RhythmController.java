package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Rhythm;
import ua.kiev.ukma.tg.service.RhythmService;

import java.util.List;

@RestController
public class RhythmController {

    @Autowired
    private RhythmService rhythmService;

    @RequestMapping(value = {"teacher/subject/{subjectId}/group/{groupId}/rhythms", "methodist/subject/{subjectId}/group/{groupId}/rhythms"}, method = RequestMethod.GET, produces = "application/json")
    public List<Rhythm> getGroupRhythms(@PathVariable int groupId) {
        return rhythmService.getByGroup(groupId);
    }

    @RequestMapping(value = "teacher/subject/{subjectId}/group/{groupId}/rhythm", method = RequestMethod.POST, produces = "application/json")
    public Rhythm add(@RequestBody Rhythm rhythm) {
    	rhythmService.add(rhythm);
        return rhythm;
    }

    @RequestMapping(value = "teacher/subject/{subjectId}/group/{groupId}/rhythm", method = RequestMethod.PUT)
    public void update(@RequestBody Rhythm rhythm) {
    	rhythmService.update(rhythm);
    }

    @RequestMapping(value = "teacher/subject/{subjectId}/group/{groupId}/rhythm/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	rhythmService.delete(id);
    }
}