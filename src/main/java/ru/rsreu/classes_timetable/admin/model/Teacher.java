package ru.rsreu.classes_timetable.admin.model;

import java.util.List;

public record Teacher (
        Long id,
        String fullName,
        List<Long> lessonsIds
) {}
