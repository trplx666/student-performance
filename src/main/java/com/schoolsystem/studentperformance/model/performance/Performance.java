package com.schoolsystem.studentperformance.model.performance;

import com.schoolsystem.studentperformance.model.student.Student;
import com.schoolsystem.studentperformance.model.lesson.Lesson;
import jakarta.persistence.*;

@Entity
@Table(name = "performances")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    private Integer grade;
    private Integer weight;
    private String comment;

    public Performance() {}

    public Performance(Student student, Lesson lesson, Integer grade, Integer weight, String comment) {
        this.student = student;
        this.lesson = lesson;
        this.grade = grade;
        this.weight = weight;
        this.comment = comment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "student=" + student +
                ", lesson=" + lesson +
                ", grade=" + grade +
                ", weight=" + weight +
                ", comment='" + comment + '\'' +
                '}';
    }
}
