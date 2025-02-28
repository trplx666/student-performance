package com.schoolsystem.studentperformance.controller.performance;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.schoolsystem.studentperformance.model.performance.Performance;
import com.schoolsystem.studentperformance.model.DTO.performance.PerformanceDto;
import com.schoolsystem.studentperformance.service.performance.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/grade")
    public ResponseEntity<?> gradeStudent(@Valid @RequestBody PerformanceDto performanceDto) {
        Performance performance = performanceService.gradeStudent(performanceDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/avgGrade")
    public ResponseEntity<Double> getStudentAverageGradeBySubject(@RequestParam Long studentId, @RequestParam Long subjectId) {
        Double averageGrade = performanceService.getStudentAverageGradeBySubject(studentId, subjectId);
        return ResponseEntity.ok(averageGrade);
    }
}
