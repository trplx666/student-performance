package com.schoolsystem.studentperformance.model.DTO.schedule;

import java.time.LocalDateTime;

public class ScheduleDto {
    private LocalDateTime lessonDate;
    private String subject;
    private String topic;
    private String professor;

    public ScheduleDto(LocalDateTime lessonDate, String subject, String topic, String professor) {
        this.lessonDate = lessonDate;
        this.subject = subject;
        this.topic = topic;
        this.professor = professor;
    }

    public LocalDateTime getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(LocalDateTime lessonDate) {
        this.lessonDate = lessonDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "lessonDate=" + lessonDate +
                ", subject='" + subject + '\'' +
                ", topic='" + topic + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
