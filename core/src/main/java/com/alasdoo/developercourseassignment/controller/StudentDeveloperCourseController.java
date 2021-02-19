package com.alasdoo.developercourseassignment.controller;

import com.alasdoo.developercourseassignment.dto.StudentDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.exceptions.RequestDataException;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.service.impl.StudentDeveloperCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/studentdevelopercourse")
@CrossOrigin
public class StudentDeveloperCourseController {

	@Autowired
	private StudentDeveloperCourseServiceImpl studentDeveloperCourseServiceImpl;

	@GetMapping(value = "/getStudentCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDeveloperCourseDTO selectStudentDeveloperCourse(@PathVariable("id") Integer id)
			throws ResourceNotFoundException {
		return studentDeveloperCourseServiceImpl.findOne(id);
	}

	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDeveloperCourseDTO> getAllStudentDeveloperCourses() {
		return studentDeveloperCourseServiceImpl.findAll();
	}

	@PostMapping(value = "/addStudentDeveloperCourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StudentDeveloperCourseDTO saveStudentDeveloperCourse(
			@RequestBody StudentDeveloperCourseDTO studentDeveloperCourseDTO)
			throws RequestDataException, ResourceNotFoundException {
		return studentDeveloperCourseServiceImpl.save(studentDeveloperCourseDTO);
	}

	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StudentDeveloperCourseDTO updateStudentDeveloperCourse(@PathVariable("id") Integer id,
			@RequestBody StudentDeveloperCourseDTO studentDeveloperCourseDTO) throws ResourceNotFoundException {
		return studentDeveloperCourseServiceImpl.update(id, studentDeveloperCourseDTO);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudentDeveloperCourse(@PathVariable("id") Integer id) throws ResourceNotFoundException {
		studentDeveloperCourseServiceImpl.remove(id);
	}

	/**
	 * Returns data about student developer course with passed student id.
	 * 
	 * @param studentId - id of student
	 * @return list of DTO objects about student developer course
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	@GetMapping(value = "/get/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDeveloperCourseDTO> findByStudentId(@PathVariable("studentId") Integer studentId)
			throws ResourceNotFoundException {
		return studentDeveloperCourseServiceImpl.findByStudentId(studentId);
	}

	/**
	 * Returns data about student developer course with passed course id.
	 * 
	 * @param courseId - id of course
	 * @return list of DTO objects about student developer course
	 * @throws ResourceNotFoundException if there is no entity with passed id
	 */
	@GetMapping(value = "/get/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentDeveloperCourseDTO> findByCourseId(@PathVariable("courseId") Integer courseId)
			throws ResourceNotFoundException {
		return studentDeveloperCourseServiceImpl.findByDeveloperCourseId(courseId);
	}
}
