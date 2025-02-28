package com.schoolsystem.studentperformance.service.lesson;

import com.schoolsystem.studentperformance.model.group.Group;
import com.schoolsystem.studentperformance.model.lesson.Lesson;
import com.schoolsystem.studentperformance.model.professor.Professor;
import com.schoolsystem.studentperformance.model.subject.Subject;
import com.schoolsystem.studentperformance.model.DTO.lesson.LessonDto;
import com.schoolsystem.studentperformance.repository.group.GroupRepository;
import com.schoolsystem.studentperformance.repository.lesson.LessonRepository;
import com.schoolsystem.studentperformance.repository.professor.ProfessorRepository;
import com.schoolsystem.studentperformance.repository.subject.SubjectRepository;
import com.schoolsystem.studentperformance.service.entity.EntityService;
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
    private EntityService entityService;

    public Lesson createLesson(LessonDto lessonDto) {
        return entityService.createEntity(lessonRepository, createLessonEntity(lessonDto));
    }

    @Transactional
    public Lesson updateLesson(Long lessonId, LessonDto lessonDto) {
        Lesson lesson = entityService.findEntityByIdOrThrow(lessonRepository,lessonId);
        return entityService.createEntity(lessonRepository, updateLessonEntityValues(lessonDto, lesson));
    }

    private Lesson createLessonEntity(LessonDto lessonDto) {
        String topic = lessonDto.getTopic();
        LocalDateTime lessonDate = lessonDto.getLessonDate();
        Subject subject = entityService.findEntityByIdOrThrow(subjectRepository, lessonDto.getSubjectId());
        Group group = entityService.findEntityByIdOrThrow(groupRepository, lessonDto.getGroupId());
        Professor professor = entityService.findEntityByIdOrThrow(professorRepository, lessonDto.getProfessorId());
        return new Lesson(topic,subject,professor,group,lessonDate);
    }

    private Lesson updateLessonEntityValues(LessonDto lessonDto, Lesson lesson) {
        entityService.updateEntityValue(lessonDto.getTopic(), lesson::setTopic);
        entityService.updateEntityValue(lessonDto.getLessonDate(), lesson::setLessonDate);
        entityService.updateEntityValue(lessonDto.getSubjectId(), id -> lesson.setSubject(entityService.findEntityByIdOrThrow(subjectRepository, id)));
        entityService.updateEntityValue(lessonDto.getProfessorId(), id -> lesson.setProfessor(entityService.findEntityByIdOrThrow(professorRepository, id)));
        entityService.updateEntityValue(lessonDto.getGroupId(), id -> lesson.setGroup(entityService.findEntityByIdOrThrow(groupRepository, id)));
        return lesson;
    }
}
