package com.crud.gestioncursos.domain.repository;

import com.crud.gestioncursos.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> getAll();

    Optional<List<Course>> getByCategory(int categoryId);

    Optional<List<Course>> getScarseCourse(int quantity);

    Optional<Course> getCourse(int courseId);

    Course save(Course course);

    void delete(int courseId);

}
