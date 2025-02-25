package com.schoolsystem.studentperformance.repository.professor;

import com.schoolsystem.studentperformance.model.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
