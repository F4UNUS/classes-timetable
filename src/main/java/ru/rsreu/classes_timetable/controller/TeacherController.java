package ru.rsreu.classes_timetable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.model.Day;
import ru.rsreu.classes_timetable.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    List<TeacherEntity> getTeachers(@RequestParam Day day, @RequestParam int auditory) {
        return teacherService.getTeachers(day, auditory);
    }

}
