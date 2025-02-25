package com.schoolsystem.studentperformance.service.student;

import com.schoolsystem.studentperformance.model.group.Group;
import com.schoolsystem.studentperformance.model.student.Student;
import com.schoolsystem.studentperformance.model.student.DTO.StudentDto;
import com.schoolsystem.studentperformance.repository.group.GroupRepository;
import com.schoolsystem.studentperformance.repository.student.StudentRepository;
import com.schoolsystem.studentperformance.service.CreatorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CreatorService creatorService;

    public Student createStudent(StudentDto studentDto) {
        Group group = groupRepository.findById(studentDto.getGroup_id())
                .orElseThrow(() -> new RuntimeException("Группа с " + studentDto.getGroup_id() + " id не найдена!"));

        Student student = new Student(studentDto.getUsername(), studentDto.getFirst_name(), studentDto.getLast_name(), studentDto.getEmail(), studentDto.getPhone_number(), group);
        return creatorService.createEntity(studentRepository, student);
    }

    @Transactional
    public Student updateStudent(Long studentId, StudentDto studentDto) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент с ID " + studentId + " не найден"));

        if (studentDto.getGroup_id() != null) {
            Group group = groupRepository.findById(studentDto.getGroup_id())
                    .orElseThrow(() -> new RuntimeException("Группа с ID " + studentDto.getGroup_id() + " не найдена"));
            student.setGroup(group);
        }

        if (studentDto.getFirst_name() != null) {
            student.setFirst_name(studentDto.getFirst_name());
        }
        if (studentDto.getLast_name() != null) {
            student.setLast_name(studentDto.getLast_name());
        }
        return creatorService.createEntity(studentRepository, student);
    }
}
