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
@Table(name = "professor")
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long id;

    @Column(unique = true) // No 2 or more professors can't have the same name
    private String name;

    private String title;

    @OneToMany(mappedBy = "my_professor")
    @JsonIgnore
    private List<SubjectEntity> subjects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "professor_student_mapping",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> students;
}
