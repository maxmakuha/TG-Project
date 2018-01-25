package ua.kiev.ukma.tg.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kiev.ukma.tg.service.AudienceTypeService;
import ua.kiev.ukma.tg.service.CourseService;
import ua.kiev.ukma.tg.service.DayService;
import ua.kiev.ukma.tg.service.GroupService;
import ua.kiev.ukma.tg.service.GroupTypeService;
import ua.kiev.ukma.tg.service.LessonService;
import ua.kiev.ukma.tg.service.ProgramService;
import ua.kiev.ukma.tg.service.SemesterService;
import ua.kiev.ukma.tg.service.SubjectService;
import ua.kiev.ukma.tg.service.TimetableService;
import ua.kiev.ukma.tg.service.UserService;
import ua.kiev.ukma.tg.service.WeekService;
import ua.kiev.ukma.tg.service.YearService;

@Controller
@RequestMapping("teacher")
public class TeachController {
	
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
	DayService dayService;
	
	@Autowired
	WeekService weekService;
	
	@Autowired
	LessonService lessonService;
	
	@Autowired
	UserService userService;

	@Autowired
	TimetableService timetableService;
	
	@GetMapping({ "", "timetables" })
	public String timetablesPage(Model model) {
		model.addAttribute("years", yearService.getAll());
		model.addAttribute("programs", programService.getAll());
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("semesters", semesterService.getAll());
		return "teachTimetables";
	}
	
	@GetMapping("timetable/{timetableId}")
	public String timetablePage(@PathVariable int timetableId, Model model) {
		model.addAttribute("timetable", timetableService.getById(timetableId));
		return "teachTimetable";
	}
	
	@GetMapping("subjects")
	public String subjectsPage(Model model) {
		model.addAttribute("years", yearService.getAll());
		model.addAttribute("programs", programService.getAll());
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("semesters", semesterService.getAll());
		return "teachSubjects";
	}
	
	@GetMapping("subject/{subjectId}/groups")
	public String subjectGroupsPage(@PathVariable int subjectId, Model model) {
		model.addAttribute("subject", subjectService.getById(subjectId));
		model.addAttribute("types", groupTypeService.getAll());
		model.addAttribute("audienceTypes", audienceTypeService.getAll());
		return "teachSubjectGroups";
	}
	
	@GetMapping("subject/{subjectId}/group/{groupId}/students")
	public String subjectGroupStudentsPage(@PathVariable int groupId, Model model) {
		model.addAttribute("group", groupService.getById(groupId));
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("programs", programService.getAll());
		model.addAttribute("weeks", weekService.getGroupWeeks(groupId));
		return "teachSubjectGroupStudents";
	}
	
	@GetMapping("absences")
	public String absencesPage(Model model, Principal user) {
		model.addAttribute("teacher", userService.getUserAuth(user.getName()));
		model.addAttribute("days", dayService.getAll());
		model.addAttribute("lessons", lessonService.getAll());
		return "teachAbsences";
	}
}