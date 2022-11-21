package ru.rsreu.classes_timetable.admin.model.converter.lesson;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;

import java.util.List;

@Component
public class LessonEntityToLessonConverter implements Converter<LessonEntity, Lesson> {

    @Override
    public Lesson convert(LessonEntity source) {
        List<Long> teachersIds = source.getTeachers().stream()
                .map(TeacherEntity::getId)
                .toList();
        return new Lesson(source.getId(),
                source.getName(),
                source.getAuditory(),
                source.getDayOfWeek(),
                teachersIds,
                source.getStudentsCount());
    }
}
