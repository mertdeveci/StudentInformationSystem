package com.SNI.SIS.Controller;

import com.SNI.SIS.Dto.StudentDto;
import com.SNI.SIS.Dto.SubjectDto;
import com.SNI.SIS.Entity.Student;
import com.SNI.SIS.Service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    // Database test object
    @GetMapping("/create")
    public ResponseEntity<StudentDto> createSampleStudent(){
        return ResponseEntity.ok(studentService.createSampleStudent());
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getSpecificStudent(
            @PathVariable(name = "id") Long id
    ){
        return ResponseEntity.ok(studentService.getSpesificStudent(id));
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){

        return ResponseEntity.ok(studentService.allStudents());
    }


    @PostMapping
    public ResponseEntity<StudentDto> createStudent(
            @Valid @RequestBody StudentDto studentDto
    ){
        return ResponseEntity.ok(studentService.createStudent(studentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable("id") Long id,
            @Valid @RequestBody StudentDto studentDto
    ){
        return ResponseEntity.ok(studentService.updateStudent(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(
            @PathVariable("id") Long id
    ){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/grade/{id}")
    public ResponseEntity<Set<SubjectDto>> getTranskript(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(studentService.getTranskript(id));
    }

    @PutMapping("grade/update/{id}")
    public ResponseEntity<Set<SubjectDto>> updateTranskript(
            @PathVariable("id") Long id,
            @Valid @RequestBody Set<SubjectDto> subject
    ){
            return ResponseEntity.ok(studentService.updateTranskript(id, subject));
    }

}
