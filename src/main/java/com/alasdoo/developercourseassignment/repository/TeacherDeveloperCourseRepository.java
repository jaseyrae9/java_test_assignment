package com.alasdoo.developercourseassignment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alasdoo.developercourseassignment.entity.TeacherDeveloperCourse;

@Repository
public interface TeacherDeveloperCourseRepository extends JpaRepository<TeacherDeveloperCourse, Integer> {

    Optional<TeacherDeveloperCourse> findByDeveloperCourseIdAndTeacherId(Integer developerCourseId, Integer teacherId);

    List<TeacherDeveloperCourse> findByTeacherId(Integer teacherId);
    List<TeacherDeveloperCourse> findByDeveloperCourseId(Integer developerCourseId);

    @Modifying 
    @Query("delete from TeacherDeveloperCourse tdc where tdc.developerCourseId = :id") 
    void deleteTeachersByDeveloperCourseId(@Param("id") Integer id); 
    
    @Modifying
    @Query("delete from TeacherDeveloperCourse tdc where tdc.teacherId = :id ")
    void deleteTeacherDeveloperCoursesByTeacherId(@Param("id") Integer id);
}
