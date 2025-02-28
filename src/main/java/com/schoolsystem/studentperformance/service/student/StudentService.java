package com.schoolsystem.studentperformance.service.student;

import com.schoolsystem.studentperformance.model.group.Group;
import com.schoolsystem.studentperformance.model.student.Student;
import com.schoolsystem.studentperformance.model.DTO.student.StudentDto;
import com.schoolsystem.studentperformance.repository.group.GroupRepository;
import com.schoolsystem.studentperformance.repository.student.StudentRepository;
import com.schoolsystem.studentperformance.service.entity.EntityService;
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
    private EntityService entityService;

    public Student createStudent(StudentDto studentDto) {
        return createStudentEntity(studentDto);
    }

    @Transactional
    public Student updateStudent(Long studentId, StudentDto studentDto) {
        Student student = entityService.findEntityByIdOrThrow(studentRepository, studentId);
        return entityService.createEntity(studentRepository, updateStudentEntityValue(studentDto, student));
    }

    private Student createStudentEntity(StudentDto studentDto) {
        String username = studentDto.getUsername();
        String firstName = studentDto.getFirstName();
        String lastName = studentDto.getLastName();
        String email = studentDto.getEmail();
        String phoneNumber = studentDto.getPhoneNumber();
        Group group = entityService.findEntityByIdOrThrow(groupRepository, studentDto.getGroupId());
        return new Student(username, firstName, lastName, email, phoneNumber, group);
    }

    private Student updateStudentEntityValue(StudentDto studentDto, Student student) {
        entityService.updateEntityValue(studentDto.getUsername(), student::setUsername);
        entityService.updateEntityValue(studentDto.getFirstName(), student::setFirstName);
        entityService.updateEntityValue(studentDto.getLastName(), student::setLastName);
        entityService.updateEntityValue(studentDto.getEmail(), student::setEmail);
        entityService.updateEntityValue(studentDto.getPhoneNumber(), student::setPhoneNumber);
        entityService.updateEntityValue(studentDto.getGroupId(), id -> student.setGroup(entityService.findEntityByIdOrThrow(groupRepository, id)));
        return student;
    }
}
