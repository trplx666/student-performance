package com.schoolsystem.studentperformance.model.DTO.performance;

public class PerformanceDto {
    private Long student_id;
    private Long lesson_id;
    private Integer grade;
    private Integer weight;
    private String comment;

    public PerformanceDto(Long student_id, Long lesson_id, Integer grade, Integer weight, String comment) {
        this.student_id = student_id;
        this.lesson_id = lesson_id;
        this.grade = grade;
        this.weight = weight;
        this.comment = comment;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
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
                "student_id=" + student_id +
                ", lesson_id=" + lesson_id +
                ", grade=" + grade +
                ", weight=" + weight +
                ", comment='" + comment + '\'' +
                '}';
    }
}
