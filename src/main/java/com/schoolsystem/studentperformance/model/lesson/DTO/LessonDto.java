package com.schoolsystem.studentperformance.model.lesson.DTO;

import java.time.LocalDateTime;

public class LessonDto {
    private String topic;
    private Long subject_id;
    private Long professor_id;
    private Long group_id;
    private LocalDateTime lessonDate;

    public LessonDto(String topic, Long subject_id, Long professor_id, Long group_id, LocalDateTime lessonDate) {
        this.topic = topic;
        this.subject_id = subject_id;
        this.professor_id = professor_id;
        this.group_id = group_id;
        this.lessonDate = lessonDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
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
                ", subject_id=" + subject_id +
                ", professor_id=" + professor_id +
                ", group_id=" + group_id +
                ", lessonDate=" + lessonDate +
                '}';
    }
}
