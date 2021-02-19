package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.StudentDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

import java.util.List;

public interface StudentDeveloperCourseService extends CrudService<StudentDeveloperCourseDTO> {

	List<StudentDeveloperCourseDTO> findByStudentId(Integer studentId) throws ResourceNotFoundException;

	List<StudentDeveloperCourseDTO> findByDeveloperCourseId(Integer developerCourseId) throws ResourceNotFoundException;

	void deleteStudentsByDeveloperCourseId(Integer courseId) throws ResourceNotFoundException;

	void deleteStudentDeveloperCoursesByStudentId(Integer studentId) throws ResourceNotFoundException;
}
