package com.university.universitySimulator.controller;


import com.university.universitySimulator.model.Course;
import com.university.universitySimulator.model.Instructor;
import com.university.universitySimulator.repo.CourseRepository;
import com.university.universitySimulator.repo.InstructorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InstructorController {

    private InstructorRepository instructorRepo;
    private CourseRepository courseRepo;


    public InstructorController(InstructorRepository instructorRepo, CourseRepository courseRepo) {
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }

    @GetMapping("/instructors")
    public Iterable<Instructor> getAllInstructors() {
        return instructorRepo.findAll();

    }

    @GetMapping("/instructors/{id}")
    public Instructor getSingleInstructor(@PathVariable long id) {
        return instructorRepo.findById(id).get();
    }
    @PostMapping("/instructors")
    public Iterable<Instructor> addInstructor(@RequestBody Instructor instructor) {
        instructorRepo.save(instructor);
        return instructorRepo.findAll();
    }

    @PutMapping("/instructors/{id}/addToCourse/{courseId}")
    public Iterable <Instructor> addInstructorToCourse(@PathVariable long id,@PathVariable long courseId){
        Optional<Instructor> instructor = instructorRepo.findById(id);
        Optional<Course> course = courseRepo.findById(courseId);
        if(instructor.isPresent() && course.isPresent()) {
            course.get().setInstructor(instructor.get());
            courseRepo.save(course.get());
        }
        return instructorRepo.findAll();
    }
}
