package com.schoolsystem.studentperformance.controller.professor;

import com.schoolsystem.studentperformance.model.DTO.lesson.ProfessorLessonDto;
import com.schoolsystem.studentperformance.service.professor.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/lessons/get/{professor_id}")
    public ResponseEntity<?> getLessons(@Valid @PathVariable("professor_id") Long professor_id) {
        List<ProfessorLessonDto> professorLessons = professorService.getLessonsByProfessorId(professor_id);
        return ResponseEntity.ok(professorLessons);
    }
}
