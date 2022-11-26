package ru.rsreu.classes_timetable.admin.model.converter.teacher;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.admin.model.Teacher;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.db.repository.LessonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class TeacherToTeacherEntityConverter implements Converter<Teacher, TeacherEntity> {

    private final LessonRepository lessonRepository;

    public TeacherToTeacherEntityConverter(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public TeacherEntity convert(Teacher source) {
        TeacherEntity target = new TeacherEntity();
        target.setId(source.id());
        target.setFullName(source.fullName());
        target.setLessons(findLessons(source.lessonsId()));
        return target;
    }

    public List<LessonEntity> findLessons(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return Collections.emptyList();
        }
        Iterator<LessonEntity> lessonEntityIterator = lessonRepository.findAllById(ids).iterator();
        List<LessonEntity> teacherEntities = new ArrayList<>();
        while (lessonEntityIterator.hasNext()) {
            teacherEntities.add(lessonEntityIterator.next());
        }
        return teacherEntities;
    }

}
