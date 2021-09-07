package com.SNI.SIS.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String firstname;
    private String lastname;
    private String phone_number;
    private Long GPU;
    private AddressDto address;
    private UniversityDto university;
    private Set<SubjectDto> subjects;
}
