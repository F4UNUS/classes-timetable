package ru.rsreu.classes_timetable.admin.model.converter.teacher;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.admin.model.Teacher;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;

import java.util.List;

@Component
public class TeacherEntityToTeacherConverter implements Converter<TeacherEntity, Teacher> {
    @Override
    public Teacher convert(TeacherEntity source) {
        List<Long> lessonsId = source.getLessons().stream().map(LessonEntity::getId).toList();
        return new Teacher(source.getId(), source.getFullName(), lessonsId);
    }
}
