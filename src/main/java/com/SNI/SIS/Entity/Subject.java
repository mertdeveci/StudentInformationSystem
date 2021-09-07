package com.SNI.SIS.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 250)
    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Subject(String subjectName, Grade grade) {
        this.name = subjectName;
        this.grade = grade;
    }
}
