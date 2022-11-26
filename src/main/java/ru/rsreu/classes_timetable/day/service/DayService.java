package ru.rsreu.classes_timetable.day.service;

import org.springframework.stereotype.Service;
import ru.rsreu.classes_timetable.db.entity.LessonEntity;
import ru.rsreu.classes_timetable.db.repository.LessonRepository;
import ru.rsreu.classes_timetable.model.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DayService {

    private final LessonRepository lessonRepository;

    public DayService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Day> getDaysByLessonCount(long lessonCount) {
        List<Day> days = new ArrayList<>();
        Arrays.stream(Day.values()).forEach(day -> {
            if (lessonRepository.countByDayOfWeek(day) == lessonCount) {
                days.add(day);
            }
        });
        return days;
    }

    public List<Day> getDaysByAuditoryCount(long auditoryCount) {
        List<Day> days = new ArrayList<>();
        Arrays.stream(Day.values()).forEach(day -> {
            Set<Integer> auditoriums = new HashSet<>();
            lessonRepository.findByDayOfWeek(day)
                    .forEach(lessonEntity -> auditoriums.add(lessonEntity.getAuditory()));
            if (auditoriums.size() == auditoryCount) {
                days.add(day);
            }
        });
        return days;
    }

}
