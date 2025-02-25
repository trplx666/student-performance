package com.schoolsystem.studentperformance.model.lesson;

import com.schoolsystem.studentperformance.model.professor.Professor;
import com.schoolsystem.studentperformance.model.subject.Subject;
import com.schoolsystem.studentperformance.model.group.Group;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    private LocalDateTime lessonDate;

    public Lesson() {

    }

    public Lesson(String topic, Subject subject, Professor professor, Group group, LocalDateTime lessonDate) {
        this.topic = topic;
        this.subject = subject;
        this.professor = professor;
        this.group = group;
        this.lessonDate = lessonDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDateTime getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(LocalDateTime lessonDate) {
        this.lessonDate = lessonDate;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "topic='" + topic + '\'' +
                ", subject=" + subject +
                ", professor=" + professor +
                ", group=" + group +
                ", lessonDate=" + lessonDate +
                '}';
    }
}
