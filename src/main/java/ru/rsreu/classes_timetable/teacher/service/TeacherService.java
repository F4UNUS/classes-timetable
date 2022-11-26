package ru.rsreu.classes_timetable.teacher.service;

import org.springframework.stereotype.Service;
import ru.rsreu.classes_timetable.db.repository.TeacherRepository;
import ru.rsreu.classes_timetable.model.Day;
import ru.rsreu.classes_timetable.teacher.converter.TeacherEntityToTeacherConverter;
import ru.rsreu.classes_timetable.teacher.dto.Teacher;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public final TeacherEntityToTeacherConverter teacherEntityToTeacherConverter;

    public TeacherService(TeacherRepository teacherRepository,
                          TeacherEntityToTeacherConverter teacherEntityToTeacherConverter) {
        this.teacherRepository = teacherRepository;
        this.teacherEntityToTeacherConverter = teacherEntityToTeacherConverter;
    }

    public List<Teacher> getTeachersWhereDayIsNot(Day day, int auditory) {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository
                .findByLessonsDayOfWeekAndLessonsAuditory(day, auditory)
                .forEach(teacherEntity -> teachers.add(teacherEntityToTeacherConverter.convert(teacherEntity)));
        return teachers;
    }

    public List<Teacher> getTeachersWhereDayIsNot(Day day) {
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository
                .findByLessonsDayOfWeekIsNot(day)
                .forEach(teacherEntity -> teachers.add(teacherEntityToTeacherConverter.convert(teacherEntity)));
        return teachers;
    }

}
