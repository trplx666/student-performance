package com.schoolsystem.studentperformance.model.DTO.student;

import jakarta.validation.constraints.NotBlank;

public class StudentDto {
    @NotBlank(message = "Ошибка. Username не должен быть пустым!")
    private String username;
    private String first_name;
    private String last_name;
    @NotBlank(message = "Ошибка. groupId не должен быть пустым!")
    private Long group_id;
    private String email;
    private String phone_number;

    public StudentDto(String username, String first_name, String last_name, Long group_id, String email, String phone_number) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.group_id = group_id;
        this.email = email;
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", group_id=" + group_id +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
