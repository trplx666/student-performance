package com.schoolsystem.studentperformance.service.performance;

import com.schoolsystem.studentperformance.model.DTO.performance.PerformanceDto;
import com.schoolsystem.studentperformance.model.performance.Performance;
import com.schoolsystem.studentperformance.model.lesson.Lesson;
import com.schoolsystem.studentperformance.model.student.Student;
import com.schoolsystem.studentperformance.repository.lesson.LessonRepository;
import com.schoolsystem.studentperformance.repository.performance.PerformanceRepository;
import com.schoolsystem.studentperformance.repository.student.StudentRepository;
import com.schoolsystem.studentperformance.service.entity.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private EntityService entityService;

    public Performance gradeStudent(PerformanceDto performanceDto) {
        return entityService.createEntity(performanceRepository, createPerformanceEntity(performanceDto));
    }

    public Double getStudentAverageGradeBySubject(Long studentId, Long subjectId) {
        List<Performance> performances = performanceRepository.findByStudentIdAndLessonSubjectId(studentId, subjectId);
        return performances.isEmpty() ? null : calculateAverageGrade(performances);
    }

    private Performance createPerformanceEntity(PerformanceDto performanceDto) {
        Student student = entityService.findEntityByIdOrThrow(studentRepository,performanceDto.getStudentId());
        Lesson lesson = entityService.findEntityByIdOrThrow(lessonRepository, performanceDto.getLessonId());
        Integer grade = performanceDto.getGrade();
        Integer weight = performanceDto.getWeight();
        String comment = performanceDto.getComment();
        return new Performance(student,lesson,grade,weight,comment);
    }

    private Double calculateAverageGrade(List<Performance> performances) {
        double weightedSum = 0;
        int totalWeight = 0;
        for (Performance performance : performances) {
            weightedSum += performance.getGrade() * performance.getWeight();
            totalWeight += performance.getWeight();
        }
        return totalWeight == 0 ? 0.0 : weightedSum / totalWeight;
    }
}
