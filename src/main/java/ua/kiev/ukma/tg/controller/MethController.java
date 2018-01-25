package ua.kiev.ukma.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kiev.ukma.tg.service.AudienceService;
import ua.kiev.ukma.tg.service.AudienceTypeService;
import ua.kiev.ukma.tg.service.CourseService;
import ua.kiev.ukma.tg.service.DayService;
import ua.kiev.ukma.tg.service.GroupService;
import ua.kiev.ukma.tg.service.GroupTypeService;
import ua.kiev.ukma.tg.service.LessonService;
import ua.kiev.ukma.tg.service.ProgramService;
import ua.kiev.ukma.tg.service.SemesterService;
import ua.kiev.ukma.tg.service.StudentService;
import ua.kiev.ukma.tg.service.SubjectService;
import ua.kiev.ukma.tg.service.TimetableService;
import ua.kiev.ukma.tg.service.UserService;
import ua.kiev.ukma.tg.service.YearService;

@Controller
@RequestMapping("methodist")
public class MethController {
	
	@Autowired
	YearService yearService;
	
	@Autowired
	ProgramService programService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	SemesterService semesterService;

	@Autowired
	AudienceTypeService audienceTypeService;
	
	@Autowired
	GroupTypeService groupTypeService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	AudienceService audienceService;
	
	@Autowired
	DayService dayService;
	
	@Autowired
	LessonService lessonService;
	
	@Autowired
	TimetableService timetableService;
	
	@GetMapping({ "", "timetables" })
	public String timetablesPage(Model model) {
		model.addAttribute("years", yearService.getAll());
		model.addAttribute("programs", programService.getAll());
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("semesters", semesterService.getAll());
		return "methTimetables";
	}
	
	@GetMapping("timetable/{timetableId}")
	public String timetablePage(@PathVariable int timetableId, Model model) {
		model.addAttribute("timetable", timetableService.getById(timetableId));
		model.addAttribute("lessons", lessonService.getAllExceptFirst());
		model.addAttribute("groups", groupService.getTimetableGroups(timetableId));
		model.addAttribute("audiences", audienceService.getAll());
		return "methTimetable";
	}
	
	@GetMapping("subjects")
	public String subjectsPage(Model model) {
		model.addAttribute("years", yearService.getAll());
		model.addAttribute("programs", programService.getAll());
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("semesters", semesterService.getAll());
		return "methSubjects";
	}
	
	@GetMapping("subject/{subjectId}/groups")
	public String subjectGroupsPage(@PathVariable int subjectId, Model model) {
		model.addAttribute("subject", subjectService.getById(subjectId));
		model.addAttribute("types", groupTypeService.getAll());
		model.addAttribute("teachers", userService.getUsersByRole("TEACHER"));
		model.addAttribute("audienceTypes", audienceTypeService.getAll());
		return "methSubjectGroups";
	}
	
	@GetMapping("subject/{subjectId}/group/{groupId}/students")
	public String subjectGroupStudentsPage(@PathVariable int subjectId, @PathVariable int groupId, Model model) {
		model.addAttribute("students", studentService.getOtherStudents(groupId));
		model.addAttribute("group", groupService.getById(groupId));
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("programs", programService.getAll());
		return "methSubjectGroupStudents";
	}
	
	@GetMapping("teachers")
	public String teachersPage() {
		return "methTeachers";
	}
	
	@GetMapping("teacher/{teacherId}")
	public String teacherInfoPage(@PathVariable int teacherId, Model model) {
		model.addAttribute("user", userService.getById(teacherId));
		model.addAttribute("days", dayService.getAll());
		model.addAttribute("lessons", lessonService.getAll());
		return "methTeacherInfo";
	}
	
	@GetMapping("students")
	public String studentsPage(Model model) {
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("programs", programService.getAll());
		return "methStudents";
	}
	
	@GetMapping({"student/{studentId}", "subject/{subjectId}/group/{groupId}/student/{studentId}"})
	public String studentInfoPage(@PathVariable int studentId, Model model) {
		model.addAttribute("user", userService.getById(studentId));
		model.addAttribute("days", dayService.getAll());
		model.addAttribute("lessons", lessonService.getAll());
		return "methStudentInfo";
	}
	
	@GetMapping("audiences")
	public String audiencesPage(Model model) {
		model.addAttribute("types", audienceTypeService.getAll());
		return "methAudiences";
	}
	
	@GetMapping("audience/{audienceId}/occupations")
	public String occupationsPage(@PathVariable int audienceId, Model model) {
		model.addAttribute("audience", audienceService.getById(audienceId));
		model.addAttribute("days", dayService.getAll());
		model.addAttribute("lessons", lessonService.getAll());
		return "methAudienceOccupations";
	}
}