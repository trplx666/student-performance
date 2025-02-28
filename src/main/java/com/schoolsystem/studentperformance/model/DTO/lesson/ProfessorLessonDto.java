package com.schoolsystem.studentperformance.model.DTO.lesson;

import java.time.LocalDateTime;

public class ProfessorLessonDto {
    private String subjectName;
    private String topic;
    private String groupName;
    private LocalDateTime lessonDate;

    public ProfessorLessonDto(String subjectName, String topic, String groupName, LocalDateTime lessonDate) {
        this.subjectName = subjectName;
        this.topic = topic;
        this.groupName = groupName;
        this.lessonDate = lessonDate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LocalDateTime getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(LocalDateTime lessonDate) {
        this.lessonDate = lessonDate;
    }

    @Override
    public String toString() {
        return "ProfessorLessonDto{" +
                "subjectName='" + subjectName + '\'' +
                ", topic='" + topic + '\'' +
                ", groupName='" + groupName + '\'' +
                ", lessonDate=" + lessonDate +
                '}';
    }
}
