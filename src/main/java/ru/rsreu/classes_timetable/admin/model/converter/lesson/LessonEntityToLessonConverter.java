package ru.rsreu.classes_timetable.admin.model.converter.lesson;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;

import java.util.Objects;

@Component
public class LessonEntityToLessonConverter implements Converter<LessonEntity, Lesson> {

    @Override
    public Lesson convert(LessonEntity source) {
        Long teacherId = null;
        if (Objects.nonNull(source.getTeacher())) {
            teacherId = source.getTeacher().getId();
        }
        return new Lesson(source.getId(),
                source.getName(),
                source.getAuditory(),
                source.getDayOfWeek(),
                source.getTime(),
                source.getStudentsCount(),
                teacherId);
    }
}
