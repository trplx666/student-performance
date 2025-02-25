package com.schoolsystem.studentperformance.repository.student;

import com.schoolsystem.studentperformance.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
