package ua.kiev.ukma.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.kiev.ukma.tg.service.CourseService;
import ua.kiev.ukma.tg.service.ProgramService;
import ua.kiev.ukma.tg.service.SemesterService;
import ua.kiev.ukma.tg.service.TimetableService;
import ua.kiev.ukma.tg.service.YearService;

@Controller
@RequestMapping("student")
public class StudController {
	
	@Autowired
	YearService yearService;
	
	@Autowired
	ProgramService programService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	SemesterService semesterService;

	@Autowired
	TimetableService timetableService;
	
	@GetMapping({ "", "timetables" })
	public String timetablePage(Model model) {
		model.addAttribute("years", yearService.getAll());
		model.addAttribute("programs", programService.getAll());
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("semesters", semesterService.getAll());
		return "studTimetables";
	}
	
	@GetMapping("timetable/{timetableId}")
	public String timetablePage(@PathVariable int timetableId, Model model) {
		model.addAttribute("timetable", timetableService.getById(timetableId));
		return "studTimetable";
	}
}