package com.SNI.SIS.Dto;

import com.SNI.SIS.Entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {

    private String name;

    private Grade grade;

}
