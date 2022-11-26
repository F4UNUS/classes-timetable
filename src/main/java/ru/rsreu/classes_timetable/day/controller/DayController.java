package ru.rsreu.classes_timetable.day.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.rsreu.classes_timetable.day.service.DayService;
import ru.rsreu.classes_timetable.model.Day;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/days")
public class DayController {

    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping
    public List<Day> getDaysByLessonsCount(Optional<Long> lessonsCount, Optional<Long> auditoryCount) {
        if (lessonsCount.isPresent() && auditoryCount.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (lessonsCount.isPresent()) {
            return dayService.getDaysByLessonCount(lessonsCount.get());
        }
        if (auditoryCount.isPresent()) {
            return dayService.getDaysByAuditoryCount(auditoryCount.get());
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

}
