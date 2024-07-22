package com.saurabbhorg.mapping.repositories;

import com.saurabbhorg.mapping.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    /*
     * Native SQL query to retrieve students based on the subject name.
     *
     * To use this query, uncomment the following method. Ensure to set nativeQuery = true
     * to indicate that this is a native SQL query rather than JPQL.
     *
     * @param subjectName the name of the subject to filter students by.
     * @return a list of students enrolled in the specified subject.
     */
    // @Query(value = "SELECT stu.* FROM student stu JOIN student_subject_mapping ss ON stu.student_id = ss.student_id JOIN subject sub ON ss.subject_id = sub.subject_id WHERE sub.name = :subjectName", nativeQuery = true)
    // List<StudentEntity> findStudentsBySubjectName(@Param("subjectName") String subjectName);

    /*
     * JPQL query to retrieve students based on the subject name.
     *
     * This query uses JPQL to join the StudentEntity with the subjects and filter by the subject name.
     * The parameter `mySubjectName` in the method is mapped to the JPQL named parameter `:mySubjectName`.
     *
     * @param mySubjectName the name of the subject to filter students by.
     * @return a list of students enrolled in the specified subject.
     */
    @Query("SELECT s FROM StudentEntity s JOIN s.subjects sub WHERE sub.name = :mySubjectName")
    List<StudentEntity> findStudentsBySubjectName(@Param("mySubjectName") String subjectName);
}
