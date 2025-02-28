package com.schoolsystem.studentperformance.repository.professor;

import com.schoolsystem.studentperformance.model.DTO.lesson.ProfessorLessonDto;
import com.schoolsystem.studentperformance.model.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("""
            SELECT new com.schoolsystem.studentperformance.model.DTO.lesson.ProfessorLessonDto(
            s.name,
            l.topic,
            g.groupName,
            l.lessonDate)
            FROM Lesson l
            JOIN l.subject s
            JOIN l.group g
            WHERE l.professor.id = :professorId
            ORDER BY l.lessonDate
            """)
    List<ProfessorLessonDto> findLessonsByProfessorId(@Param("professorId") Long professorId);
}
