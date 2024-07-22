package com.saurabbhorg.mapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProfessorEntity> professors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
          name = "student_subject_mapping",
          joinColumns = @JoinColumn(name = "student_id"),
          inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<SubjectEntity> subjects;

    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private AdmissionRecordEntity admissionRecord;
}
