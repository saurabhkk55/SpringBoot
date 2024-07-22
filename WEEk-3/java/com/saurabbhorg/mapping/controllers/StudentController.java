package com.saurabbhorg.mapping.controllers;

import com.saurabbhorg.mapping.entities.StudentEntity;
import com.saurabbhorg.mapping.entities.SubjectEntity;
import com.saurabbhorg.mapping.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

//    A student can not get admission in the college without registration
//    Meaning, While doing registration we should do the admission as well
//    @PostMapping
//    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity) {
//        return studentService.createNewStudent(studentEntity);
//    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{student_id}")
    public Optional<StudentEntity> getStudentById(@PathVariable Long student_id) {
        return studentService.getStudentById(student_id);
    }

    @GetMapping(path = "/subject_name/{subject_name}")
    public List<StudentEntity> getAllStudentsBySubjectName(@PathVariable String subject_name) {
        return studentService.getAllStudentsBySubjectName(subject_name);
    }

//    @PostMapping(path = "assign_subject/{subject_name}/to_student/{student_id}")
//    public StudentEntity assignSubjectToStudent(@PathVariable String subject_name, @PathVariable Long student_id) {
//        return studentService.assignSubjectToStudent(subject_name, student_id);
//    }

    @GetMapping(path = "/subjects/{student_id}")
    public List<String> getSubjectsOfStudent(@PathVariable Long student_id) {
        return studentService.getSubjectsOfStudent(student_id);
    }
}
