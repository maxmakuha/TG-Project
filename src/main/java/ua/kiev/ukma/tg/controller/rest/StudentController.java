package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Student;
import ua.kiev.ukma.tg.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("methodist")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST, produces = "application/json")
    public Student add(@RequestBody Student student) {
        studentService.add(student);
        return student;
    }

    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public void update(@RequestBody Student student) {
    	studentService.update(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	studentService.delete(id);
    }
}