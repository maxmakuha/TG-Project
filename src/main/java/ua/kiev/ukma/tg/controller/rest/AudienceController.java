package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Audience;
import ua.kiev.ukma.tg.service.AudienceService;

import java.util.List;

@RestController
@RequestMapping("methodist")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @RequestMapping(value = "/audiences", method = RequestMethod.GET, produces = "application/json")
    public List<Audience> getAll() {
        return audienceService.getAll();
    }

    @RequestMapping(value = "/audience", method = RequestMethod.POST, produces = "application/json")
    public Audience add(@RequestBody Audience audience) {
        audienceService.add(audience);
        return audience;
    }

    @RequestMapping(value = "/audience", method = RequestMethod.PUT)
    public void update(@RequestBody Audience audience) {
    	audienceService.update(audience);
    }

    @RequestMapping(value = "/audience/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	audienceService.delete(id);
    }
}