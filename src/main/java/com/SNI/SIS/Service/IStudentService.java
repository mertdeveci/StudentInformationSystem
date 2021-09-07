package com.SNI.SIS.Service;

import com.SNI.SIS.Dto.StudentDto;
import com.SNI.SIS.Dto.SubjectDto;
import com.SNI.SIS.Entity.Student;

import java.util.List;
import java.util.Set;

public interface IStudentService {
    List<Student> allStudents();

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getSpesificStudent(Long id);

    StudentDto updateStudent(Long id, StudentDto studentDto);

    boolean deleteStudent(Long id);

    StudentDto createSampleStudent();

    Set<SubjectDto> getTranskript(Long id);

    Set<SubjectDto> updateTranskript(Long id, Set<SubjectDto> subject);
}
