package ru.rsreu.classes_timetable.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.classes_timetable.db.entity.TeacherEntity;
import ru.rsreu.classes_timetable.model.Day;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
    List<TeacherEntity> findByLessonsDayOfWeekAndLessonsAuditory(Day day, int auditory);
    List<TeacherEntity> findByLessonsDayOfWeekIsNot(Day day);
}
