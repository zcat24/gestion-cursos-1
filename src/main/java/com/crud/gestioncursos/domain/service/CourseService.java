package com.crud.gestioncursos.domain.service;

import com.crud.gestioncursos.domain.Course;
import com.crud.gestioncursos.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.getAll();
    }

    public Optional<Course> getCourse(int courseId){

        return courseRepository.getCourse(courseId);
    }

    public Optional<List<Course>> getByCategory(int categoryId){

        return courseRepository.getByCategory(categoryId);
    }

    public  Optional<List<Course>> getScarseCourse(int quantity){

        return courseRepository.getScarseCourse(quantity);
    }

    public Course save(Course course){
        return  courseRepository.save(course);
    }

    public  boolean delete (int courseId){
        return getCourse(courseId).map(course -> {
            courseRepository.delete(courseId);
            return true;
        }).orElse(false);
    }

 /*   public  boolean delete (int courseId){ //otra manera de llamar al metodo delete desde el repository
        if (getCourse(courseId).isPresent()){
            courseRepository.delete(courseId);
            return true;
        } else {
            return false;
        }
    }*/

}
