package com.alasdoo.developercourseassignment.service;

import java.util.List;

import com.alasdoo.developercourseassignment.dto.TeacherDeveloperCourseDTO;

public interface TeacherDeveloperCourseService extends CrudService<TeacherDeveloperCourseDTO> {

    List<TeacherDeveloperCourseDTO> findByTeacherId(Integer teacherId);
    List<TeacherDeveloperCourseDTO> findByDeveloperCourseId(Integer developerCourseId);
    void deleteTeachersByDeveloperCourseId(Integer courseId);

}
