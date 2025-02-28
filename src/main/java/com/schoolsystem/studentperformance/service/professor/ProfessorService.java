package com.schoolsystem.studentperformance.service.professor;

import com.schoolsystem.studentperformance.model.DTO.lesson.ProfessorLessonDto;
import com.schoolsystem.studentperformance.repository.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorLessonDto> getLessonsByProfessorId(Long professorId) {
        return professorRepository.findLessonsByProfessorId(professorId);
    }
}
