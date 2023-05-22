package com.crud.gestioncursos.web.controller;


import com.crud.gestioncursos.domain.Course;
import com.crud.gestioncursos.domain.service.CourseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    @ApiOperation("Get all Courses")
    @ApiResponse(code =200, message = "OK")
    public ResponseEntity<List<Course>> getAll(){

        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code =200, message = "OK"),
            @ApiResponse(code =404, message = "Course Not Found")
    })
    public ResponseEntity<Course> getCourse(@ApiParam(value = "The Id of the Course", required = true, example = "4")
                                                @PathVariable("id") int courseId){

        return courseService.getCourse(courseId)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Course>> getByCategory(@PathVariable("categoryId")int categoryId){

        return courseService.getByCategory(categoryId)
                .map(courses -> new ResponseEntity<>(courses, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/quantity/{quantity}")
    public  ResponseEntity<List<Course>> getScarseCourse(@PathVariable("quantity")int quantity){

        return courseService.getScarseCourse(quantity)
                .map(courses -> new ResponseEntity<>(courses, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course){

        return  new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int courseId){
        if (courseService.delete(courseId)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
