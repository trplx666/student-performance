package com.schoolsystem.studentperformance.service.lesson;

import com.schoolsystem.studentperformance.model.group.Group;
import com.schoolsystem.studentperformance.model.lesson.Lesson;
import com.schoolsystem.studentperformance.model.professor.Professor;
import com.schoolsystem.studentperformance.model.subject.Subject;
import com.schoolsystem.studentperformance.model.lesson.DTO.LessonDto;
import com.schoolsystem.studentperformance.repository.group.GroupRepository;
import com.schoolsystem.studentperformance.repository.lesson.LessonRepository;
import com.schoolsystem.studentperformance.repository.professor.ProfessorRepository;
import com.schoolsystem.studentperformance.repository.subject.SubjectRepository;
import com.schoolsystem.studentperformance.service.CreatorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CreatorService creatorService;

    public Lesson createLesson(LessonDto lessonDto) {
        String topic = lessonDto.getTopic();
        LocalDateTime lessonDate = lessonDto.getLessonDate();
        Subject subject = subjectRepository.findById(lessonDto.getSubject_id())
                .orElseThrow(() -> new RuntimeException("Предмет с id " + lessonDto.getSubject_id() + " не найден!"));

        Group group = groupRepository.findById(lessonDto.getGroup_id())
                .orElseThrow(() -> new RuntimeException("Группа с id " + lessonDto.getGroup_id() + " не найдена!"));

        Professor professor = professorRepository.findById(lessonDto.getProfessor_id())
                .orElseThrow(() -> new RuntimeException("Преподаватель с id " + lessonDto.getProfessor_id() + " не найден!"));

        Lesson lesson = new Lesson(topic,subject,professor,group, lessonDate);
        return creatorService.createEntity(lessonRepository, lesson);
    }

    @Transactional
    public Lesson updateLesson(Long lessonId, LessonDto lessonDto) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Урок с ID " + lessonId + " не найден"));

        if (lessonDto.getTopic() != null) {
            lesson.setTopic(lessonDto.getTopic());
        }

        if (lessonDto.getLessonDate() != null) {
            lesson.setLessonDate(lessonDto.getLessonDate());
        }

        if (lessonDto.getSubject_id() != null) {
            Subject subject = subjectRepository.findById(lessonDto.getSubject_id())
                    .orElseThrow(() -> new RuntimeException("Предмет с ID " + lessonDto.getSubject_id() + " не найден"));
            lesson.setSubject(subject);
        }

        if (lessonDto.getProfessor_id() != null) {
            Professor professor = professorRepository.findById(lessonDto.getProfessor_id())
                    .orElseThrow(() -> new RuntimeException("Преподаватель с ID " + lessonDto.getProfessor_id() + " не найден"));
            lesson.setProfessor(professor);
        }

        if (lessonDto.getGroup_id() != null) {
            Group group = groupRepository.findById(lessonDto.getGroup_id())
                    .orElseThrow(() -> new RuntimeException("Группа с ID " + lessonDto.getGroup_id() + " не найдена"));
            lesson.setGroup(group);
        }

        return creatorService.createEntity(lessonRepository, lesson);
    }
}
