package ua.kiev.ukma.tg.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Group;
import ua.kiev.ukma.tg.model.GroupStudent;
import ua.kiev.ukma.tg.model.Student;
import ua.kiev.ukma.tg.service.StudentService;

import java.util.List;

@RestController
public class GroupStudentController {

    @Autowired
    private StudentService studentService;
    
    @RequestMapping(value = {"methodist/subject/{subjectId}/group/{groupId}/students", "teacher/subject/{subjectId}/group/{groupId}/students"}, method = RequestMethod.GET, produces = "application/json")
    public List<GroupStudent> getAll(@PathVariable int groupId) {
        return studentService.getStudentsByGroup(groupId);
    }
    
    @RequestMapping(value = "methodist/subject/{subjectId}/group/{groupId}/students/other", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getOtherStudents(@PathVariable int subjectId, @PathVariable int groupId) {
        return studentService.getOtherStudents(groupId);
    }

    @RequestMapping(value = "methodist/subject/{subjectId}/group/{groupId}/student", method = RequestMethod.POST, produces = "application/json")
    public GroupStudent add(@RequestBody GroupStudent student, @PathVariable int subjectId, @PathVariable int groupId) {
        studentService.add(student.getStudent());
        studentService.addToGroup(student);
        return student;
    }
    
    @RequestMapping(value = "methodist/subject/{subjectId}/group/{groupId}/student/{studentId}", method = RequestMethod.POST, produces = "application/json")
    public GroupStudent addToGroup(@RequestBody GroupStudent student, @PathVariable int subjectId, @PathVariable int groupId, @PathVariable int studentId) {
        studentService.addToGroup(student);
        return student;
    }

    @RequestMapping(value = "methodist/subject/{subjectId}/group/{groupId}/student", method = RequestMethod.PUT)
    public void update(@RequestBody GroupStudent student) {
    	studentService.update(student.getStudent());
    }
    
    @RequestMapping(value = "methodist/subject/{subjectId}/group/{groupId}/student/other", method = RequestMethod.PUT)
    public void updateOtherStudent(@RequestBody Student student) {
    	studentService.update(student);
    }

    @RequestMapping(value = "methodist/subject/{subjectId}/group/{groupId}/student/{student_id}/{group_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int student_id, @PathVariable int group_id) {
    	studentService.deleteFromGroup(new GroupStudent(new Student (student_id), new Group (group_id)));
    }
}