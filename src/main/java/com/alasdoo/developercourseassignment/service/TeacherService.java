package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;

public interface TeacherService extends CrudService<TeacherDTO> {

	TeacherDTO findByTeacherEmail(String email);

	TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surnameo);
}
