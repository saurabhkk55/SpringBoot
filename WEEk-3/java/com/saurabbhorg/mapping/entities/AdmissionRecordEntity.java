package com.saurabbhorg.mapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "admission_record")
public class AdmissionRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id")
    private Long id;

    private Long fees;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
//    @JsonIgnore
    private StudentEntity student;
}

// Post Mapping at http://localhost:8080/admissionRecord
//{
//    "id": 52,
//    "fees": 50000,
//    "student": {
//        "id": 52,
//        "name": "Student52-new"
//    }
//}