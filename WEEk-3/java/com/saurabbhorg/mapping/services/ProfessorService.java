package com.saurabbhorg.mapping.services;

import com.saurabbhorg.mapping.entities.ProfessorEntity;
import com.saurabbhorg.mapping.entities.StudentEntity;
import com.saurabbhorg.mapping.entities.SubjectEntity;
import com.saurabbhorg.mapping.repositories.ProfessorRepository;
import com.saurabbhorg.mapping.repositories.StudentRepository;
import com.saurabbhorg.mapping.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<ProfessorEntity> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Optional<ProfessorEntity> getProfessorById(Long professor_id) {
        return professorRepository.findById(professor_id);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    public Boolean deleteExistingProfessor(Long professor_id) {
        Optional<ProfessorEntity> professorEntity = getProfessorById(professor_id);
        if(professorEntity.isPresent()) {
            professorRepository.deleteById(professor_id);
            return true;
        }
        return false;
    }

    public List<String> getAllSubjectsOfProfessor(Long professorId) {
        Optional<ProfessorEntity> professorEntity = getProfessorById(professorId);
        List<String> subjects = new ArrayList<>();
        if(professorEntity.isPresent()) {
            for (SubjectEntity subjectEntity : professorEntity.get().getSubjects()) {
                subjects.add(subjectEntity.getName());
            }
            return subjects;
        }
        return subjects;
    }

    public ProfessorEntity assignStudentToProfessor(Long studentId, Long professorId) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
        Optional<ProfessorEntity> professorEntity = professorRepository.findById(professorId);
        if(studentEntity.isPresent() && professorEntity.isPresent()) {
            List<StudentEntity> studentEntities = professorEntity.get().getStudents();
            studentEntities.add(studentEntity.get());
            professorEntity.get().setStudents(studentEntities);
            return professorRepository.save(professorEntity.get());
        }
        return null;
    }

//    public ProfessorEntity assignSubjectToProfessor(String SubjectName, Long professorId) {
//        Optional<ProfessorEntity> professorEntity = getProfessorById(professorId);
//        Optional<SubjectEntity> subjectEntity = subjectRepository.findByName(SubjectName);
//        if(professorEntity.isPresent() && subjectEntity.isPresent()) {
//            System.out.println("Hello----------------");
//            List<SubjectEntity> subjectEntities = professorEntity.get().getSubjects();
//            subjectEntities.add(subjectEntity.get());
//            professorEntity.get().setSubjects(subjectEntities);
//            return professorRepository.save(professorEntity.get());
//        }
//        return null;
//    }

}
