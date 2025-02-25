package com.schoolsystem.studentperformance.repository.performance;

import com.schoolsystem.studentperformance.model.performance.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    List<Performance> findByStudentIdAndLessonSubjectId(Long studentId, Long subjectId);
}
