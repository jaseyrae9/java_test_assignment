package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.DeveloperCourseDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

import java.util.List;

public interface DeveloperCourseService extends CrudService<DeveloperCourseDTO> {

	List<DeveloperCourseDTO> findByDeveloperCourseName(String developerCourseName) throws ResourceNotFoundException;

	List<DeveloperCourseDTO> findByDeveloperCourseByStudentId(Integer studentId) throws ResourceNotFoundException;

	List<DeveloperCourseDTO> findByDeveloperCourseByTeacherId(Integer teacherId) throws ResourceNotFoundException;
}
