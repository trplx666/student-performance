package com.schoolsystem.studentperformance.model.DTO.performance;

public class PerformanceDto {
    private Long studentId;
    private Long lessonId;
    private Integer grade;
    private Integer weight;
    private String comment;

    public PerformanceDto(Long studentId, Long lessonId, Integer grade, Integer weight, String comment) {
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.grade = grade;
        this.weight = weight;
        this.comment = comment;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
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
        return "PerformanceDto{" +
                "studentId=" + studentId +
                ", lessonId=" + lessonId +
                ", grade=" + grade +
                ", weight=" + weight +
                ", comment='" + comment + '\'' +
                '}';
    }
}
