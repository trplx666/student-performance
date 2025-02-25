package com.schoolsystem.studentperformance.repository.subject;

import com.schoolsystem.studentperformance.model.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
