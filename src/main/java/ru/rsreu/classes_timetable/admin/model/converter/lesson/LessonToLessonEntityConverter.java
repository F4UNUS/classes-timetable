package ru.rsreu.classes_timetable.admin.model.converter.lesson;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.db.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class LessonToLessonEntityConverter implements Converter<Lesson, LessonEntity> {

    private final TeacherRepository teacherRepository;

    public LessonToLessonEntityConverter(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public LessonEntity convert(Lesson source) {
        LessonEntity target = new LessonEntity();
        target.setId(source.id());
        target.setName(source.name());
        target.setAuditory(source.auditory());
        target.setDayOfWeek(source.day());
        target.setStudentsCount(source.studentsCount());
        target.setTeachers(findTeachers(source.teachersIds()));
        return target;
    }

    public List<TeacherEntity> findTeachers(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        Iterator<TeacherEntity> teacherEntityIterator = teacherRepository.findAllById(ids).iterator();
        List<TeacherEntity> teacherEntities = new ArrayList<>();
        while (teacherEntityIterator.hasNext()) {
            teacherEntities.add(teacherEntityIterator.next());
        }
        return teacherEntities;
    }

}
