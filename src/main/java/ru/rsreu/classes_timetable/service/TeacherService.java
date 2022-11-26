package ru.rsreu.classes_timetable.service;

import org.springframework.stereotype.Service;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.db.repository.TeacherRepository;
import ru.rsreu.classes_timetable.model.Day;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherEntity> getTeachers(Day day, int auditory) {

        return teacherRepository.findByLessonsDayOfWeekAndLessonsAuditory(day, auditory);
    }

}
