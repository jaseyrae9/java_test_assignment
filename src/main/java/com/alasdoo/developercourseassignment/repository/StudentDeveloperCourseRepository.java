package com.alasdoo.developercourseassignment.repository;

import com.alasdoo.developercourseassignment.entity.StudentDeveloperCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDeveloperCourseRepository extends JpaRepository<StudentDeveloperCourse, Integer> {

    Optional<StudentDeveloperCourse> findByStudentId(Integer studentId);

    Optional<List<StudentDeveloperCourse>> findByDeveloperCourseId(Integer developerCourseId);

    Optional<StudentDeveloperCourse> findByDeveloperCourseIdAndStudentId(Integer developerCourseId, Integer studentId);
    
    @Modifying 
    @Query("delete from StudentDeveloperCourse sdc where sdc.developerCourseId = :id") 
    void deleteStudentsByDeveloperCourseId(@Param("id") Integer id); 
    
    @Modifying
    @Query("delete from StudentDeveloperCourse sdc where sdc.studentId = :id ")
    void deleteStudentDeveloperCoursesByStudentId(@Param("id") Integer id);
}
