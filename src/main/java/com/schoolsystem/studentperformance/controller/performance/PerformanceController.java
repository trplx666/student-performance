package com.schoolsystem.studentperformance.controller.performance;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.schoolsystem.studentperformance.model.performance.Performance;
import com.schoolsystem.studentperformance.model.performance.DTO.PerformanceDto;
import com.schoolsystem.studentperformance.service.performance.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/performance")
@Validated
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;


    @PostMapping("/rate")
    public ResponseEntity<?> rateStudent(@RequestBody PerformanceDto performanceDto) {
        Performance performance = performanceService.rateStudent(performanceDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/avgMark")
    public ResponseEntity<Double> getStudentAverageGradeBySubject(@RequestParam Long studentId, @RequestParam Long subjectId) {
        Double averageGrade = performanceService.getStudentAverageGradeBySubject(studentId, subjectId);
        return ResponseEntity.ok(averageGrade);
    }
}
