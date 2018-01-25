package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Occupation;
import ua.kiev.ukma.tg.service.OccupationService;

import java.util.List;

@RestController
@RequestMapping("methodist")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @RequestMapping(value = "/audience/{audienceId}/occupations", method = RequestMethod.GET, produces = "application/json")
    public List<Occupation> getAudienceOccupations(@PathVariable int audienceId) {
        return occupationService.getByAudience(audienceId);
    }

    @RequestMapping(value = "/audience/{audienceId}/occupation", method = RequestMethod.POST, produces = "application/json")
    public Occupation add(@RequestBody Occupation occupation) {
    	occupationService.add(occupation);
        return occupation;
    }

    @RequestMapping(value = "/audience/{audienceId}/occupation", method = RequestMethod.PUT)
    public void update(@RequestBody Occupation occupation) {
    	occupationService.update(occupation);
    }

    @RequestMapping(value = "/audience/{audienceId}/occupation/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	occupationService.delete(id);
    }
}