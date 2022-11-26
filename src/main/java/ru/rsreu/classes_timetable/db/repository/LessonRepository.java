package ru.rsreu.classes_timetable.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;

@Repository
public interface LessonRepository extends CrudRepository<LessonEntity, Long> {

}
