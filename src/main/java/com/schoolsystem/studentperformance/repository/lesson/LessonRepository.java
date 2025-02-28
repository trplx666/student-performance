package com.schoolsystem.studentperformance.repository.lesson;

import com.schoolsystem.studentperformance.model.DTO.schedule.ScheduleDto;
import com.schoolsystem.studentperformance.model.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("""
            SELECT new com.schoolsystem.studentperformance.model.DTO.schedule.ScheduleDto(
                l.lessonDate,
                s.name,
                l.topic,
                CONCAT(p.firstName, ' ', p.lastName)
            )
            FROM Lesson l
            JOIN l.subject s
            JOIN l.professor p
            JOIN l.group g
            WHERE g.groupName = :groupName
            ORDER BY l.lessonDate
            """)
    List<ScheduleDto> findScheduleByGroupName(@Param("groupName") String groupName);
}
