package ru.rsreu.classes_timetable.model.converter;

import org.springframework.core.convert.converter.Converter;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.model.Lesson;

public class LessonEntityToLessonConverter implements Converter<LessonEntity, Lesson> {

    @Override
    public Lesson convert(LessonEntity source) {
        return null;
    }
}
