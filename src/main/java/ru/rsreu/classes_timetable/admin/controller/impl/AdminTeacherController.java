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
import ru.rsreu.classes_timetable.admin.model.Teacher;
import ru.rsreu.classes_timetable.admin.service.AdminTeacherService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/teachers")
public class AdminTeacherController implements AdminController<Teacher, Long> {

    private final AdminTeacherService adminTeacherService;

    public AdminTeacherController(AdminTeacherService adminTeacherService) {
        this.adminTeacherService = adminTeacherService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Teacher>> get() {
        return ResponseEntity.of(Optional.of(adminTeacherService.getTeachers()));
    }

    @Override
    @PostMapping
    public void insert(@RequestBody Teacher teacher) {
        adminTeacherService.insertTeacher(teacher);
    }

    @Override
    @PutMapping
    public void update(@RequestBody Teacher teacher) {
        adminTeacherService.updateTeacher(teacher);
    }

    @Override
    @DeleteMapping(path = {"/id"})
    public void delete(@PathVariable Long id) {
        adminTeacherService.deleteTeacher(id);
    }
}
