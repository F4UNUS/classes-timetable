package ru.rsreu.classes_timetable.admin.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.admin.model.Teacher;
import ru.rsreu.classes_timetable.admin.model.converter.teacher.TeacherEntityToTeacherConverter;
import ru.rsreu.classes_timetable.admin.model.converter.teacher.TeacherToTeacherEntityConverter;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.db.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminTeacherService {

    private final TeacherEntityToTeacherConverter teacherEntityToTeacherConverter;
    private final TeacherToTeacherEntityConverter teacherToTeacherEntityConverter;
    private final TeacherRepository teacherRepository;

    public AdminTeacherService(TeacherEntityToTeacherConverter teacherEntityToTeacherConverter,
                               TeacherToTeacherEntityConverter teacherToTeacherEntityConverter,
                               TeacherRepository teacherRepository) {
        this.teacherEntityToTeacherConverter = teacherEntityToTeacherConverter;
        this.teacherToTeacherEntityConverter = teacherToTeacherEntityConverter;
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
        Iterator<TeacherEntity> teacherEntityIterator = teacherRepository.findAll().iterator();
        List<Teacher> teachers = new ArrayList<>();
        while (teacherEntityIterator.hasNext()) {
            TeacherEntity teacherEntity = teacherEntityIterator.next();
            Teacher teacher = teacherEntityToTeacherConverter.convert(teacherEntity);
            teachers.add(teacher);
        }
        return teachers;
    }

    public void insertTeacher(Teacher teacher) {
        teacherRepository.save(Objects.requireNonNull(teacherToTeacherEntityConverter.convert(teacher)));
    }

    public void updateTeacher(Teacher teacher) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(teacher.id());
        if (teacherEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find teacher");
        }
        TeacherEntity updatableTeacher = teacherEntity.get();
        TeacherEntity newTeacher = teacherToTeacherEntityConverter.convert(teacher);
        updatableTeacher.setFullName(newTeacher.getFullName());
        updatableTeacher.setLessons(newTeacher.getLessons());
        teacherRepository.save(updatableTeacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

}
