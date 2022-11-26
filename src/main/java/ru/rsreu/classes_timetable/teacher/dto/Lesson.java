package ru.rsreu.classes_timetable.teacher.dto;

import ru.rsreu.classes_timetable.model.Day;

import java.time.LocalTime;

public record Lesson(
        String name,
        int auditory,
        Day day,
        LocalTime time,
        int studentsCount
) { }
