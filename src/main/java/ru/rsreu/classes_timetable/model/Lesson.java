package ru.rsreu.classes_timetable.model;

public record Lesson(
        String name,
        int auditory,
        Day day,
        int studentsCount
) { }
