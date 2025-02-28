package com.schoolsystem.studentperformance.model.DTO.lesson;

import java.time.LocalDateTime;

public class LessonDto {
    private String topic;
    private Long subjectId;
    private Long professorId;
    private Long groupId;
    private LocalDateTime lessonDate;

    public LessonDto(String topic, Long subjectId, Long professorId, Long groupId, LocalDateTime lessonDate) {
        this.topic = topic;
        this.subjectId = subjectId;
        this.professorId = professorId;
        this.groupId = groupId;
        this.lessonDate = lessonDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public LocalDateTime getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(LocalDateTime lessonDate) {
        this.lessonDate = lessonDate;
    }

    @Override
    public String toString() {
        return "LessonDto{" +
                "topic='" + topic + '\'' +
                ", subjectId=" + subjectId +
                ", professorId=" + professorId +
                ", groupId=" + groupId +
                ", lessonDate=" + lessonDate +
                '}';
    }
}
