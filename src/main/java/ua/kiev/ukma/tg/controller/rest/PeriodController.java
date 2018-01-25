package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Period;
import ua.kiev.ukma.tg.service.PeriodService;

import java.util.List;

@RestController
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @RequestMapping(value = {"methodist/timetable/{timetableId}", "teacher/timetable/{timetableId}", "student/timetable/{timetableId}"}, method = RequestMethod.GET, produces = "application/json")
    public List<Period> getByTimetable(@PathVariable int timetableId) {
        return periodService.getByTimetable(timetableId);
    }

    @RequestMapping(value = "methodist/timetable/{timetableId}/period", method = RequestMethod.POST, produces = "application/json")
    public Period add(@RequestBody Period period) {
    	if(periodService.checkPeriod(period)){
        periodService.add(period);
        return period;
    	} else {
    		return null;
    	}
    }

    @RequestMapping(value = "methodist/timetable/{timetableId}/period", method = RequestMethod.PUT)
    public void update(@RequestBody Period period) {
    	periodService.update(period);
    }

    @RequestMapping(value = "methodist/timetable/{timetableId}/period/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	periodService.delete(id);
    }
}