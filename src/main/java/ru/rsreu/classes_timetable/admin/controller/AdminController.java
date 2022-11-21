package ru.rsreu.classes_timetable.admin.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminController <E, ID> {
    public ResponseEntity<List<E>> get();

    public void insert(E entity);

    public void update(E entity);

    public void delete(ID id);
}
