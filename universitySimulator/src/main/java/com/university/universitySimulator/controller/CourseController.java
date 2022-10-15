package com.university.universitySimulator.controller;

import com.university.universitySimulator.model.Course;
import com.university.universitySimulator.repo.CourseRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    private CourseRepository courseRepo;

    public CourseController(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @GetMapping("/courses")
    public Iterable<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getSingleCourse(@PathVariable long id){
        return courseRepo.findById(id).get();
    }

    @PostMapping("/courses")
    public Iterable<Course> addNewCourse(@RequestBody Course newCourse){
        courseRepo.save(newCourse);
        return courseRepo.findAll();
    }

}
