package com.schoolsystem.studentperformance.service.performance;

import com.schoolsystem.studentperformance.model.performance.DTO.PerformanceDto;
import com.schoolsystem.studentperformance.model.performance.Performance;
import com.schoolsystem.studentperformance.model.lesson.Lesson;
import com.schoolsystem.studentperformance.model.student.Student;
import com.schoolsystem.studentperformance.repository.lesson.LessonRepository;
import com.schoolsystem.studentperformance.repository.performance.PerformanceRepository;
import com.schoolsystem.studentperformance.repository.student.StudentRepository;
import com.schoolsystem.studentperformance.service.CreatorService;
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
    private CreatorService creatorService;
    public Performance rateStudent(PerformanceDto performanceDto) {
        Student student = studentRepository.findById(performanceDto.getStudent_id())
                .orElseThrow(() -> new RuntimeException("Студент с ID " + performanceDto.getStudent_id() + " не найден"));

        Lesson lesson = lessonRepository.findById(performanceDto.getLesson_id())
                .orElseThrow(() -> new RuntimeException("Урок с ID " + performanceDto.getLesson_id() + " не найден"));

        Performance performance = new Performance(student, lesson, performanceDto.getGrade(), performanceDto.getWeight(), performanceDto.getComment());

        return creatorService.createEntity(performanceRepository, performance);
    }

    public Double getStudentAverageGradeBySubject(Long studentId, Long subjectId) {
        List<Performance> performances = performanceRepository.findByStudentIdAndLessonSubjectId(studentId, subjectId);

        if (performances.isEmpty()) {
            return null; // или можно вернуть 0.0
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
