package ru.rsreu.classes_timetable.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.model.Day;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<LessonEntity, Long> {

    long countByDayOfWeek(Day day);

    List<LessonEntity> findByDayOfWeek(Day day);

}
