package ru.rsreu.classes_timetable.teacher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rsreu.classes_timetable.model.Day;
import ru.rsreu.classes_timetable.teacher.dto.Teacher;
import ru.rsreu.classes_timetable.teacher.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    List<Teacher> getTeachers(@RequestParam Day day, @RequestParam int auditory) {
        return teacherService.getTeachersWhereDayIsNot(day, auditory);
    }

    @GetMapping(path = "/day-not")
    List<Teacher> getTeachersDayIsNot(@RequestParam Day day) {
        return teacherService.getTeachersWhereDayIsNot(day);
    }

}
