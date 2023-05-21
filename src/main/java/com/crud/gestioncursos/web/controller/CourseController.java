package com.crud.gestioncursos.web.controller;


import com.crud.gestioncursos.domain.Course;
import com.crud.gestioncursos.domain.service.CourseService;

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
    /*@Operation(summary = "Get all supermarket products")
    @ApiResponse(responseCode = "200", description = "OK")*/
    public ResponseEntity<List<Course>> getAll(){

        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
  /*  @Operation(summary = "Search a product with an ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })*/
    public ResponseEntity<Course> getCourse(@PathVariable("id") int courseId){

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
