package com.university.universitySimulator.repo;

import com.university.universitySimulator.model.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {
}
