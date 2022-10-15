package com.university.universitySimulator.repo;

import com.university.universitySimulator.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
