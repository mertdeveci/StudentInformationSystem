package com.SNI.SIS.Repository;

import com.SNI.SIS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
