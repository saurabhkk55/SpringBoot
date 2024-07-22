package com.saurabbhorg.mapping.services;

import com.saurabbhorg.mapping.entities.ProfessorEntity;
import com.saurabbhorg.mapping.entities.StudentEntity;
import com.saurabbhorg.mapping.entities.SubjectEntity;
import com.saurabbhorg.mapping.repositories.ProfessorRepository;
import com.saurabbhorg.mapping.repositories.StudentRepository;
import com.saurabbhorg.mapping.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<SubjectEntity> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Optional<SubjectEntity> getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity assignSubjectToProfessor(String subjectName, Long professorId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findByName(subjectName);
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        if(subjectEntity.isPresent() && professorEntity.isPresent()) {
            System.out.println("HELLO___________1");
            if(subjectEntity.get().getMy_professor() == null) {
                System.out.println("HELLO___________2");
                subjectEntity.get().setMy_professor(professorEntity.get());
                return subjectRepository.save(subjectEntity.get());
            }
            return subjectEntity.get();
        }
        return null;
    }

    public StudentEntity assignSubjectToStudent(String subjectName, Long studentId) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findByName(subjectName);
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);

        if(subjectEntity.isPresent() && studentEntity.isPresent()) {
            List<SubjectEntity> subjectEntities;
            subjectEntities = studentEntity.get().getSubjects();
            subjectEntities.add(subjectEntity.get());
            studentEntity.get().setSubjects(subjectEntities);
            return studentRepository.save(studentEntity.get());
        }
        return null;
    }

    public Boolean deleteSubjectById(Long subjectId) {
        Optional<SubjectEntity> subjectEntity = getSubjectById(subjectId);
        if(subjectEntity.isPresent()) {
            for(StudentEntity studentEntity : subjectEntity.get().getStudents()) {
                studentEntity.getSubjects().remove(subjectEntity.get());
            }

            // Set the professor associated with the subject to null
            // This is necessary because the relationship is set to CascadeType.ALL,
            // which means that if we delete the subject, the associated professor
            // will also be deleted from the professor table.
            // By setting it to null, we prevent the professor from being deleted.
            subjectEntity.get().setMy_professor(null);

            subjectRepository.save(subjectEntity.get());
            subjectRepository.deleteById(subjectId);
            return true;
        }
        return false;
    }
}
