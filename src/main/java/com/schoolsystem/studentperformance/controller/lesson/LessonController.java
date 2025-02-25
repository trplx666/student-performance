package com.schoolsystem.studentperformance.controller.lesson;

import com.schoolsystem.studentperformance.model.lesson.Lesson;
import com.schoolsystem.studentperformance.model.lesson.DTO.LessonDto;
import com.schoolsystem.studentperformance.service.lesson.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/lessons")
@Validated
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping("/create")
    public ResponseEntity<?> createLesson(@RequestBody LessonDto lessonDto) {
        Lesson lesson = lessonService.createLesson(lessonDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLesson(@PathVariable Long id, @RequestBody LessonDto lessonDto) {
        try {
            Lesson updatedLesson = lessonService.updateLesson(id, lessonDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
