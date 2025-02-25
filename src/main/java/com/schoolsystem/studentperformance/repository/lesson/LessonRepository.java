package com.schoolsystem.studentperformance.repository.lesson;

import com.schoolsystem.studentperformance.model.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
