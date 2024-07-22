package com.saurabbhorg.mapping.controllers;

import com.saurabbhorg.mapping.entities.ProfessorEntity;
import com.saurabbhorg.mapping.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorEntity> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping(path = "/{professor_id}")
    public Optional<ProfessorEntity> getProfessorById(@PathVariable Long professor_id) {
        return professorService.getProfessorById(professor_id);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity) {
        return professorService.createNewProfessor(professorEntity);
    }

    @DeleteMapping(path = "/{professor_id}")
    public Boolean deleteExistingProfessor(@PathVariable Long professor_id) {
        return professorService.deleteExistingProfessor(professor_id);
    }

    @GetMapping(path = "/subjects/{professor_id}")
    public List<String> getAllSubjectsOfProfessor(@PathVariable Long professor_id) {
        return professorService.getAllSubjectsOfProfessor(professor_id);
    }

//    @GetMapping("/assignSubject/{subject_name}/toProfessor/{professor_id}")
//    public ProfessorEntity assignSubjectToProfessor(@PathVariable String subject_name, @PathVariable Long professor_id) {
//        return professorService.assignSubjectToProfessor(subject_name, professor_id);
//    }

    @GetMapping(path = "/assign_student/{student_id}/to_professor/{professor_id}")
    public ProfessorEntity assignStudentToProfessor(@PathVariable Long student_id, @PathVariable Long professor_id) {
        return professorService.assignStudentToProfessor(student_id, professor_id);
    }
}
