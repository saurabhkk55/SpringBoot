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
@Table(name = "subject")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id")
    private ProfessorEntity my_professor;

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentEntity> students;
}

// Create professor entry via Subject: cascade = {CascadeType.PERSIST, CascadeType.MERGE}
// {
//     "name": "French",
//     "professor": {
//          "name": "Kishore",
//          "title": "Kishore_title"
//     }
// }
