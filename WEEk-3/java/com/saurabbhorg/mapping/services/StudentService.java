package com.saurabbhorg.mapping.services;

import com.saurabbhorg.mapping.entities.StudentEntity;
import com.saurabbhorg.mapping.entities.SubjectEntity;
import com.saurabbhorg.mapping.repositories.StudentRepository;
import com.saurabbhorg.mapping.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

//    public StudentEntity assignSubjectToStudent(String subjectName, Long studentId) {
//        Optional<SubjectEntity> subjectEntity = subjectRepository.findByName(subjectName);
//        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
//
//        if(subjectEntity.isPresent() && studentEntity.isPresent()) {
//            List<SubjectEntity> subjectEntities;
//            subjectEntities = studentEntity.get().getSubjects();
//            subjectEntities.add(subjectEntity.get());
//            studentEntity.get().setSubjects(subjectEntities);
//            return studentRepository.save(studentEntity.get());
//        }
//        return null;
//    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentEntity> getAllStudentsBySubjectName(String subjectName) {
        return studentRepository.findStudentsBySubjectName(subjectName);
    }

    public Optional<StudentEntity> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public List<String> getSubjectsOfStudent(Long studentId) {
        Optional<StudentEntity> studentEntity = getStudentById(studentId);
        List<String> subjectNames = new ArrayList<>();
        if(studentEntity.isPresent()) {
            for(SubjectEntity subjectEntity : studentEntity.get().getSubjects()) {
                String subjectName = subjectEntity.getName();
                subjectNames.add(subjectName);
            }
            return subjectNames;
        } else {
            return subjectNames;
        }
    }
}
