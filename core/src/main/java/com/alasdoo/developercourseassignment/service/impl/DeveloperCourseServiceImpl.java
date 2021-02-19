package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdoo.developercourseassignment.dto.DeveloperCourseDTO;
import com.alasdoo.developercourseassignment.entity.DeveloperCourse;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.mapper.DeveloperCourseMapper;
import com.alasdoo.developercourseassignment.repository.DeveloperCourseRepository;
import com.alasdoo.developercourseassignment.repository.StudentRepository;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.DeveloperCourseService;

@Service
public class DeveloperCourseServiceImpl implements DeveloperCourseService {

	@Autowired
	private DeveloperCourseRepository developerCourseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private DeveloperCourseMapper developerCourseMapper;

	@Autowired
	private TeacherDeveloperCourseServiceImpl teacherDeveloperCourseServiceImpl;

	@Autowired
	private StudentDeveloperCourseServiceImpl studentDeveloperCourseServiceImpl;

	@Override
	public DeveloperCourseDTO findOne(Integer id) throws ResourceNotFoundException {
		Optional<DeveloperCourse> developerCourse = developerCourseRepository.findById(id);
		if (!developerCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Developer course not found.");
		}
		return developerCourseMapper.transformToDTO(developerCourse.get());
	}

	@Override
	public List<DeveloperCourseDTO> findAll() {
		return developerCourseRepository.findAll().stream().map(i -> developerCourseMapper.transformToDTO(i))
				.collect(Collectors.toList());
	}

	@Override
	public DeveloperCourseDTO save(DeveloperCourseDTO developerCourseDTO) {
		DeveloperCourse developerCourse = developerCourseMapper.transformToEntity(developerCourseDTO);
		return developerCourseMapper.transformToDTO(developerCourseRepository.save(developerCourse));
	}

	@Transactional
	@Override
	public void remove(Integer id) throws IllegalArgumentException, ResourceNotFoundException {
		Optional<DeveloperCourse> developerCourse = developerCourseRepository.findById(id);
		if (!developerCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Developer course not found.");
		}

		// when course is deleted it has to be deleted from teacher and student
		// developer courses
		teacherDeveloperCourseServiceImpl.deleteTeachersByDeveloperCourseId(id);
		studentDeveloperCourseServiceImpl.deleteStudentsByDeveloperCourseId(id);
		developerCourseRepository.deleteById(id);
	}

	@Override
	public DeveloperCourseDTO update(Integer id, DeveloperCourseDTO developerCourseDTO)
			throws ResourceNotFoundException {
		Optional<DeveloperCourse> oldDeveloperCourse = developerCourseRepository.findById(id);
		if (!oldDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Developer course not found.");
		}
		oldDeveloperCourse.get().setDeveloperCourseName(developerCourseDTO.getDeveloperCourseName());
		oldDeveloperCourse.get().setClassesPerWeek(developerCourseDTO.getClassesPerWeek());
		oldDeveloperCourse.get().setCostPerClass(developerCourseDTO.getCostPerClass());
		developerCourseRepository.save(oldDeveloperCourse.get());
		return developerCourseMapper.transformToDTO(oldDeveloperCourse.get());
	}

	@Override
	public List<DeveloperCourseDTO> findByDeveloperCourseName(String developerCourseName)
			throws ResourceNotFoundException {
		Optional<List<DeveloperCourse>> developerCourses = developerCourseRepository
				.findByDeveloperCourseName(developerCourseName);
		if (!developerCourses.isPresent()) {
			throw new ResourceNotFoundException(developerCourseName, "Developer course not found.");
		}
		return developerCourseMapper.transformToListOfDTO(developerCourses.get());
	}

	@Override
	public List<DeveloperCourseDTO> findByDeveloperCourseByStudentId(Integer studentId)
			throws ResourceNotFoundException {
		if (!studentRepository.findById(studentId).isPresent()) {
			throw new ResourceNotFoundException(studentId.toString(), "Student not found.");
		}
		Optional<List<DeveloperCourse>> developerCourses = developerCourseRepository
				.findDevCourseByStudentId(studentId);
		if (!developerCourses.isPresent()) {
			throw new ResourceNotFoundException(studentId.toString(), "Courses are not found for student.");
		}
		return developerCourseMapper.transformToListOfDTO(developerCourses.get());
	}

	@Override
	public List<DeveloperCourseDTO> findByDeveloperCourseByTeacherId(Integer teacherId)
			throws ResourceNotFoundException {
		if (!teacherRepository.findById(teacherId).isPresent()) {
			throw new ResourceNotFoundException(teacherId.toString(), "Teacher not found.");
		}
		Optional<List<DeveloperCourse>> developerCourses = developerCourseRepository
				.findDevCourseByTeacherId(teacherId);
		if (!developerCourses.isPresent()) {
			throw new ResourceNotFoundException(teacherId.toString(), "Courses are not found for teacher.");
		}
		return developerCourseMapper.transformToListOfDTO(developerCourses.get());
	}
}
