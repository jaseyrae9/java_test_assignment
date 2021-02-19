package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;

public interface TeacherService extends CrudService<TeacherDTO> {

	TeacherDTO findByTeacherEmail(String email) throws ResourceNotFoundException;

	TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surnameo) throws ResourceNotFoundException;
}
