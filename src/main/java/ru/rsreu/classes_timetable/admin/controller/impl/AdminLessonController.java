package ru.rsreu.classes_timetable.admin.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rsreu.classes_timetable.admin.controller.AdminController;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.admin.service.AdminLessonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/lessons")
public class AdminLessonController implements AdminController<Lesson, Long> {
    private final AdminLessonService adminLessonService;

    public AdminLessonController(AdminLessonService adminLessonService) {
        this.adminLessonService = adminLessonService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Lesson>> get() {
        return ResponseEntity.of(Optional.of(adminLessonService.getLessons()));
    }

    @Override
    @PostMapping
    public void insert(@RequestBody Lesson lesson) {
        adminLessonService.insertLesson(lesson);
    }

    @Override
    @PutMapping
    public void update(@RequestBody Lesson lesson) {
        adminLessonService.updateLesson(lesson);
    }

    @Override
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        adminLessonService.deleteLesson(id);
    }

}
