package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

public interface TeacherService extends CrudService<TeacherDTO> {

	/**
	 * Returns data about teacher with passed name and surname.
	 * 
	 * @param email - email of the teacher
	 * @return DTO object of the teacher
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	TeacherDTO findByTeacherEmail(String email) throws ResourceNotFoundException;

	/**
	 * Returns data about teacher with provided name and surname.
	 * 
	 * @param name - name of the teacher
	 * @param surname - surname of the teacher
	 * @return DTO object of the teacher
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) throws ResourceNotFoundException;
}
