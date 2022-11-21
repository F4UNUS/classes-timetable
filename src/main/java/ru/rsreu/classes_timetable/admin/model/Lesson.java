package ru.rsreu.classes_timetable.admin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.rsreu.classes_timetable.model.Day;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record Lesson(
        long id,
        String name,
        int auditory,
        Day day,
        List<Long> teachersIds,
        int studentsCount
        ) {}
