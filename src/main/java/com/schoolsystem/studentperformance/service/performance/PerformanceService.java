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
    public Performance rateStudent(PerformanceDto performanceDto) {
        Student student = studentRepository.findById(performanceDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Студент с ID " + performanceDto.getStudentId() + " не найден"));

        Lesson lesson = lessonRepository.findById(performanceDto.getLessonId())
                .orElseThrow(() -> new RuntimeException("Урок с ID " + performanceDto.getLessonId() + " не найден"));

        Performance performance = new Performance(student, lesson, performanceDto.getGrade(), performanceDto.getWeight(), performanceDto.getComment());

        return entityService.createEntity(performanceRepository, performance);
    }

    public Double getStudentAverageGradeBySubject(Long studentId, Long subjectId) {
        List<Performance> performances = performanceRepository.findByStudentIdAndLessonSubjectId(studentId, subjectId);

        if (performances.isEmpty()) {
            return null;
        }

        double weightedSum = 0;
        int totalWeight = 0;

        for (Performance performance : performances) {
            weightedSum += performance.getGrade() * performance.getWeight();
            totalWeight += performance.getWeight();
        }

        return totalWeight == 0 ? 0.0 : weightedSum / totalWeight;
    }
}
