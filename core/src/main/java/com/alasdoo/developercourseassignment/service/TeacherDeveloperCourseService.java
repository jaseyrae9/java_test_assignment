package com.alasdoo.developercourseassignment.service;

import java.util.List;

import com.alasdoo.developercourseassignment.dto.TeacherDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

public interface TeacherDeveloperCourseService extends CrudService<TeacherDeveloperCourseDTO> {

	List<TeacherDeveloperCourseDTO> findByTeacherId(Integer teacherId) throws ResourceNotFoundException;

	List<TeacherDeveloperCourseDTO> findByDeveloperCourseId(Integer developerCourseId) throws ResourceNotFoundException;

	void deleteTeachersByDeveloperCourseId(Integer courseId) throws ResourceNotFoundException;

	void deleteTeacherDeveloperCourseByTeacherId(Integer teacherId) throws ResourceNotFoundException;
}
