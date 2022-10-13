package com.university.universitySimulator.controller;

import com.university.universitySimulator.model.Course;
import com.university.universitySimulator.repo.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private CourseRepository courseRepo;

    public CourseController(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @GetMapping("/course")
    public Iterable<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @GetMapping("/course/{id}")
    public Course getSingleCourse(@PathVariable long id){
        return courseRepo.findById(id).get();
    }

}
