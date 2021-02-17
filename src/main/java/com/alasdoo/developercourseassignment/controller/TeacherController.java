package com.alasdoo.developercourseassignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.service.impl.TeacherServiceImpl;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

	@Autowired
	TeacherServiceImpl teacherServiceImpl;

	/**
	 * Returns data about teacher with the selected id.
	 * 
	 * @param id - id of teacher
	 * @return DTO object with teacher id, name, surname and email
	 */
	@GetMapping(value = "/getTeacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDTO selectTeacher(@PathVariable("id") Integer id) {
		return teacherServiceImpl.findOne(id);
	}

	/**
	 * Returns DTO objects for teachers. Object contain id, name, surname and email.
	 * 
	 * @return information about all teachers.
	 */
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TeacherDTO> getAllTeachers() {
		return teacherServiceImpl.findAll();
	}

	/**
	 * Adds new teacher.
	 * 
	 * @param teacherDTO - contains information about the teacher
	 * @return DTO object of created teacher
	 */
	@PostMapping(value = "/addTeacher", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDTO saveTeacher(@Valid @RequestBody TeacherDTO teacherDTO) {
		return teacherServiceImpl.save(teacherDTO);
	}

	/**
	 * Returns data about teacher with the provided email.
	 * 
	 * @param email - email of the teacher
	 * @return DTO object of teacher
	 */
	@GetMapping(value = "/get/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDTO findByEmail(@PathVariable("email") String email) {
		return teacherServiceImpl.findByTeacherEmail(email);
	}

	/**
	 * Returns data about teacher with the provided name and surname.
	 * 
	 * @param name    - name of the teacher
	 * @param surname - surname of the teacher
	 * @return DTO object of teacher
	 */
	@GetMapping(value = "/get/{name}/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDTO findByNameAndSurname(@PathVariable("name") String name, @PathVariable("surname") String surname) {
		return teacherServiceImpl.findByTeacherNameAndTeacherSurname(name, surname);
	}

	/**
	 * Edits the existing teacher with selected id.
	 * 
	 * @param id         - id of the teacher
	 * @param teacherDTO - contains new information about the teacher
	 * @return updated teacher
	 */
	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDTO updateTeacher(@PathVariable("id") Integer id, @RequestBody TeacherDTO teacherDTO) {
		return teacherServiceImpl.update(id, teacherDTO);
	}

	/**
	 * Deletes the existing teacher with selected id.
	 * 
	 * @param id - id of the teacher
	 */
	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTeacher(@PathVariable("id") Integer id) {
		teacherServiceImpl.remove(id);
	}

}
