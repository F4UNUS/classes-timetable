package ru.rsreu.classes_timetable.teacher.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.teacher.dto.Teacher;

@Component("teacherEntityToTeacherConverter2")
public class TeacherEntityToTeacherConverter implements Converter<TeacherEntity, Teacher> {

    private final LessonEntityToLessonConverter lessonEntityToLessonConverter;

    public TeacherEntityToTeacherConverter(LessonEntityToLessonConverter lessonEntityToLessonConverter) {
        this.lessonEntityToLessonConverter = lessonEntityToLessonConverter;
    }

    @Override
    public Teacher convert(TeacherEntity source) {
        return new Teacher(source.getFullName(), source.getLessons().stream()
                .map(lessonEntityToLessonConverter::convert)
                .toList());
    }
}
