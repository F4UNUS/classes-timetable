package ru.rsreu.classes_timetable.admin.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.rsreu.classes_timetable.admin.model.Lesson;
import ru.rsreu.classes_timetable.admin.model.converter.lesson.LessonEntityToLessonConverter;
import ru.rsreu.classes_timetable.admin.model.converter.lesson.LessonToLessonEntityConverter;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.repository.LessonRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminLessonService {

    private final LessonEntityToLessonConverter lessonEntityToLessonConverter;
    private final LessonToLessonEntityConverter lessonToLessonEntityConverter;
    private final LessonRepository lessonRepository;

    public AdminLessonService(LessonEntityToLessonConverter lessonEntityToLessonConverter,
                              LessonToLessonEntityConverter lessonToLessonEntityConverter,
                              LessonRepository lessonRepository) {
        this.lessonEntityToLessonConverter = lessonEntityToLessonConverter;
        this.lessonToLessonEntityConverter = lessonToLessonEntityConverter;
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessons() {
        Iterator<LessonEntity> lessonEntityIterator = lessonRepository.findAll().iterator();
        List<Lesson> lessons = new ArrayList<>();
        while (lessonEntityIterator.hasNext()) {
            LessonEntity lessonEntity = lessonEntityIterator.next();
            Lesson lesson = lessonEntityToLessonConverter.convert(lessonEntity);
            lessons.add(lesson);
        }
        return lessons;
    }

    public void insertLesson(Lesson lesson) {
        lessonRepository.save(Objects.requireNonNull(lessonToLessonEntityConverter.convert(lesson)));
    }

    public void updateLesson(Lesson lesson) {
        Optional<LessonEntity> lessonEntity = lessonRepository.findById(lesson.id());
        if (lessonEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find lesson");
        }
        LessonEntity updatableLesson = lessonEntity.get();
        LessonEntity newLesson = lessonToLessonEntityConverter.convert(lesson);
        updatableLesson.setName(newLesson.getName());
        updatableLesson.setAuditory(newLesson.getAuditory());
        updatableLesson.setDayOfWeek(newLesson.getDayOfWeek());
        updatableLesson.setStudentsCount(newLesson.getStudentsCount());
        updatableLesson.setTeacher(newLesson.getTeacher());
        lessonRepository.save(updatableLesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

}
