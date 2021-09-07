package com.SNI.SIS.Service.ServiceImpl;

import com.SNI.SIS.Dto.StudentDto;
import com.SNI.SIS.Dto.SubjectDto;
import com.SNI.SIS.Entity.*;
import com.SNI.SIS.Repository.IStudentRepository;
import com.SNI.SIS.Service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentService(IStudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto getSpesificStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if( student.isPresent()){
            return modelMapper.map(student.get(),StudentDto.class);
        }
        return new StudentDto();
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
       Student student= studentRepository.getById(id);

        if(student==null){
            throw new NoSuchElementException("Kullanıcı bulunamadı.");
        }

        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());
        student.setPhone_number(studentDto.getPhone_number());
        student.setAddress(modelMapper.map(studentDto.getAddress(),Address.class));
        student.setUniversity(modelMapper.map(studentDto.getUniversity(),University.class));

        Set<Subject> subjects = new HashSet<>();

        for (SubjectDto s:studentDto.getSubjects()) {
            subjects.add(modelMapper.map(s,Subject.class));
        }

        student.setSubjects(subjects);

        studentRepository.save(student);

        return getSpesificStudent(id);
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepository.deleteById(id);

        if(!studentRepository.existsById(id)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public StudentDto createSampleStudent() {

        // Üniversite Bilgileri
        Address university_address = new Address();
            university_address.setCity("İstanbul");
            university_address.setDistrict("Beylikdüzü");
            university_address.setAddressDetail("Üniversite adresi bu kısımda yer alacak");

        University university = new University();
            university.setName("Gelişim Üniversitesi");
            university.setAddress(university_address);

        // Öğrenci Bilgileri
        Address student_address = new Address();
            student_address.setCity("İstanbul");
            student_address.setDistrict("Tarabya");
            student_address.setAddressDetail("Adresiniz bu kısımda yer alacak");

        Subject subject1= new Subject();
            subject1.setName("Türkçe");
            subject1.setGrade(Grade.BA);

        Subject subject2= new Subject();
            subject2.setName("Matematik");
            subject2.setGrade(Grade.CB);

        Set<Subject> subjects = new HashSet<>();
            subjects.add(subject1);
            subjects.add(subject2);

        Student student = new Student();
            student.setFirstname("Ümit");
            student.setLastname("Can");
            student.setPhone_number("99999");
            student.setUniversity(university);
            student.setAddress(student_address);
            student.setSubjects(subjects);

        student = studentRepository.save(student);

        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public Set<SubjectDto> getTranskript(Long id) {
        Set<SubjectDto> subjects = new HashSet<>();
        Student student = studentRepository.getById(id);

        if(student == null){
            throw new NoSuchElementException("Kullanıcı bulunamadı");
        }

        for (Subject subject:student.getSubjects()) {
            subjects.add(modelMapper.map(subject,SubjectDto.class ));
        }

        return subjects;
    }

    @Override
    public Set<SubjectDto> updateTranskript(Long id, Set<SubjectDto> subject) {
        Set<Subject> subjects = new HashSet<>();
        Student student = studentRepository.getById(id);

        if(student == null){
            throw new NoSuchElementException("Kullanıcı bulunamadı");
        }

        for (SubjectDto s:subject) {
            subjects.add(modelMapper.map(s,Subject.class));
        }

        student.setSubjects(subjects);

        return getTranskript(id);

    }


}
