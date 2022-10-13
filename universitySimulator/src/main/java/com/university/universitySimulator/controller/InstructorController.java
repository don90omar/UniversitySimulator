package com.university.universitySimulator.controller;


import com.university.universitySimulator.model.Instructor;
import com.university.universitySimulator.repo.InstructorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    private InstructorRepository instructorRepo;

    public InstructorController(InstructorRepository instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @GetMapping("/instructors")
    public Iterable<Instructor> getAllInstructors() {
        return instructorRepo.findAll();

    }

    @GetMapping("/instructor/{id}")
    public Instructor getSingleInstructor(@PathVariable long id) {
        return instructorRepo.findById(id).get();
    }
}
