package ru.rsreu.classes_timetable.teacher.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.teacher.dto.Lesson;

@Component("lessonEntityToLessonConverter2")
public class LessonEntityToLessonConverter implements Converter<LessonEntity, Lesson> {
    @Override
    public Lesson convert(LessonEntity source) {
        return new Lesson(source.getName(),
                source.getAuditory(),
                source.getDayOfWeek(),
                source.getTime(),
                source.getStudentsCount());
    }
}
