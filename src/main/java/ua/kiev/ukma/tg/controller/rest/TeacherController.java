package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.User;
import ua.kiev.ukma.tg.service.UserService;

import java.util.List;

@RestController
@RequestMapping("methodist")
public class TeacherController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAll() {
        return userService.getUsersByRole("TEACHER");
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST, produces = "application/json")
    public User add(@RequestBody User user) {
        userService.addTeacher(user);
        return user;
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
    	userService.update(user);
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	userService.delete(id);
    }
}