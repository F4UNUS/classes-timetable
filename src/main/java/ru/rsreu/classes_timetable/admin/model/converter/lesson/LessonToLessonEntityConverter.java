package ru.rsreu.classes_timetable.admin.model.converter.lesson;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.repository.TeacherRepository;

import java.util.Objects;

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
        target.setDayOfWeek(source.day());
        target.setTime(source.time());
        target.setAuditory(source.auditory());
        if (Objects.nonNull(source.teacherId())) {
            teacherRepository
                    .findById(source.teacherId())
                    .ifPresent(target::setTeacher);
        }
        return target;
    }

}
