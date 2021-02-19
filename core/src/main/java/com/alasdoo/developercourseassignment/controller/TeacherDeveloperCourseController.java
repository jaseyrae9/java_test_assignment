package com.alasdoo.developercourseassignment.controller;

import com.alasdoo.developercourseassignment.dto.TeacherDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.exceptions.RequestDataException;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.service.impl.TeacherDeveloperCourseServiceImpl;
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

import java.util.List;

@RestController
@RequestMapping("/teacherdevelopercourse")
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherDeveloperCourseController {

	@Autowired
	private TeacherDeveloperCourseServiceImpl teacherDeveloperCourseServiceImpl;

	@GetMapping(value = "/getTeacherCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDeveloperCourseDTO selectTeacherDeveloperCourse(@PathVariable("id") Integer id)
			throws ResourceNotFoundException {
		return teacherDeveloperCourseServiceImpl.findOne(id);
	}

	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TeacherDeveloperCourseDTO> getAllTeacherDeveloperCourses() {
		return teacherDeveloperCourseServiceImpl.findAll();
	}

	@PostMapping(value = "/addTeacherCourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDeveloperCourseDTO saveTeacherDeveloperCourse(
			@RequestBody TeacherDeveloperCourseDTO teacherDeveloperCourseDTO)
			throws ResourceNotFoundException, RequestDataException {
		return teacherDeveloperCourseServiceImpl.save(teacherDeveloperCourseDTO);
	}

	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TeacherDeveloperCourseDTO updateTeacherDeveloperCourse(@PathVariable("id") Integer id,
			@RequestBody TeacherDeveloperCourseDTO teacherDeveloperCourseDTO) throws ResourceNotFoundException {
		return teacherDeveloperCourseServiceImpl.update(id, teacherDeveloperCourseDTO);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTeacherDeveloperCourse(@PathVariable("id") Integer id)
			throws IllegalArgumentException, ResourceNotFoundException {
		teacherDeveloperCourseServiceImpl.remove(id);
	}

	/**
	 * Returns data about teacher developer course with passed teacher id.
	 * 
	 * @param teacherId - id of teacher
	 * @return list of DTO objects about teacher developer course
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	@GetMapping(value = "/get/teacher/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TeacherDeveloperCourseDTO> findByTeacherId(@PathVariable("teacherId") Integer teacherId)
			throws ResourceNotFoundException {
		return teacherDeveloperCourseServiceImpl.findByTeacherId(teacherId);
	}

	/**
	 * Returns data about teacher developer course with passed developer course id.
	 * 
	 * @param developerCourseId - id of developer course
	 * @return list of DTO objects about teacher developer course
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	@GetMapping(value = "/get/developerCource/{developerCourseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TeacherDeveloperCourseDTO> findByDeveloperCourseId(
			@PathVariable("developerCourseId") Integer developerCourseId) throws ResourceNotFoundException {
		return teacherDeveloperCourseServiceImpl.findByDeveloperCourseId(developerCourseId);
	}

}
