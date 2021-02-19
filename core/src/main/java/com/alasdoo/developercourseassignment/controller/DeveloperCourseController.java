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

import com.alasdoo.developercourseassignment.dto.DeveloperCourseDTO;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.service.impl.DeveloperCourseServiceImpl;

@RestController
@RequestMapping("/developercourse")
@CrossOrigin
public class DeveloperCourseController {

	@Autowired
	private DeveloperCourseServiceImpl developerCourseServiceImpl;

	@GetMapping(value = "/getCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DeveloperCourseDTO selectDeveloperCourse(@PathVariable("id") Integer id) throws ResourceNotFoundException {
		return developerCourseServiceImpl.findOne(id);
	}

	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeveloperCourseDTO> getAllDeveloperCourses() {
		return developerCourseServiceImpl.findAll();
	}

	@PostMapping(value = "/addDeveloperCourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DeveloperCourseDTO saveDeveloperCourse(@Valid @RequestBody DeveloperCourseDTO developerCourseDTO) {
		return developerCourseServiceImpl.save(developerCourseDTO);
	}

	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DeveloperCourseDTO updateDeveloperCourse(@PathVariable("id") Integer id,
			@Valid @RequestBody DeveloperCourseDTO developerCourseDTO) throws ResourceNotFoundException {
		return developerCourseServiceImpl.update(id, developerCourseDTO);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDeveloperCourse(@PathVariable("id") Integer id) throws ResourceNotFoundException {
		developerCourseServiceImpl.remove(id);
	}

	@GetMapping(value = "/get/{courseName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeveloperCourseDTO> findByDeveloperCourseName(@PathVariable("courseName") String courseName)
			throws ResourceNotFoundException {
		return developerCourseServiceImpl.findByDeveloperCourseName(courseName);
	}

	@GetMapping(value = "/getByStudentId/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeveloperCourseDTO> getDeveloperCourseByStudentId(@PathVariable("studentId") Integer studentId)
			throws ResourceNotFoundException {
		return developerCourseServiceImpl.findByDeveloperCourseByStudentId(studentId);
	}

	@GetMapping(value = "/getByTeacherId/{teacherId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeveloperCourseDTO> getDeveloperCourseByTeacherId(@PathVariable("teacherId") Integer teacherId)
			throws ResourceNotFoundException {
		return developerCourseServiceImpl.findByDeveloperCourseByTeacherId(teacherId);
	}

}
