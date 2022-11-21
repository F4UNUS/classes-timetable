package ru.rsreu.classes_timetable.db.entity;

import ru.rsreu.classes_timetable.model.Day;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lessons")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    private int auditory;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private Day dayOfWeek;

    @Column(name = "students_count")
    private int studentsCount;

    @ManyToMany
    @JoinTable(
            name = "teacher_lesson",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teachers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuditory() {
        return auditory;
    }

    public void setAuditory(int auditory) {
        this.auditory = auditory;
    }

    public Day getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Day dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public List<TeacherEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }
}
