package ru.rsreu.classes_timetable.teacher.dto;

import java.util.List;

public record Teacher(
        String fullName,
        List<Lesson> lessons
) { }
