package com.saurabbhorg.mapping.controllers;

import com.saurabbhorg.mapping.entities.ProfessorEntity;
import com.saurabbhorg.mapping.entities.StudentEntity;
import com.saurabbhorg.mapping.entities.SubjectEntity;
import com.saurabbhorg.mapping.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<SubjectEntity> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping(path = "/{subject_id}")
    public Optional<SubjectEntity> getSubjectById(@PathVariable Long subject_id) {
        return subjectService.getSubjectById(subject_id);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity) {
        return subjectService.createNewSubject(subjectEntity);
    }

    @GetMapping(path = "assign_subject/{subject_name}/to_professor/{professor_id}")
    public SubjectEntity assignSubjectToProfessor(@PathVariable String subject_name, @PathVariable Long professor_id) {
        return subjectService.assignSubjectToProfessor(subject_name, professor_id);
    }

    @GetMapping(path = "assign_subject/{subject_name}/to_student/{student_id}")
    public StudentEntity assignSubjectToStudent(@PathVariable String subject_name, @PathVariable Long student_id) {
        return subjectService.assignSubjectToStudent(subject_name, student_id);
    }

    @DeleteMapping(path = "/{subject_id}")
    public Boolean deleteSubjectById(@PathVariable Long subject_id) {
        return subjectService.deleteSubjectById(subject_id);
    }
}
