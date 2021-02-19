package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdoo.developercourseassignment.dto.StudentDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.entity.DeveloperCourse;
import com.alasdoo.developercourseassignment.entity.Student;
import com.alasdoo.developercourseassignment.entity.StudentDeveloperCourse;
import com.alasdoo.developercourseassignment.exceptions.RequestDataException;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.mapper.StudentDeveloperCourseMapper;
import com.alasdoo.developercourseassignment.repository.DeveloperCourseRepository;
import com.alasdoo.developercourseassignment.repository.StudentDeveloperCourseRepository;
import com.alasdoo.developercourseassignment.repository.StudentRepository;
import com.alasdoo.developercourseassignment.service.StudentDeveloperCourseService;

@Service
public class StudentDeveloperCourseServiceImpl implements StudentDeveloperCourseService {

	@Autowired
	private StudentDeveloperCourseRepository studentDeveloperCourseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DeveloperCourseRepository developerCourseRepository;

	@Autowired
	private StudentDeveloperCourseMapper studentDeveloperCourseMapper;

	@Override
	public StudentDeveloperCourseDTO findOne(Integer id) throws ResourceNotFoundException {
		Optional<StudentDeveloperCourse> studentDeveloperCourse = studentDeveloperCourseRepository.findById(id);
		if (!studentDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Student developer course not found.");
		}
		return studentDeveloperCourseMapper.transformToDTO(studentDeveloperCourse.get());
	}

	@Override
	public List<StudentDeveloperCourseDTO> findAll() {
		return studentDeveloperCourseRepository.findAll().stream()
				.map(i -> studentDeveloperCourseMapper.transformToDTO(i)).collect(Collectors.toList());
	}

	@Override
	public StudentDeveloperCourseDTO save(StudentDeveloperCourseDTO studentDeveloperCourseDTO)
			throws RequestDataException, ResourceNotFoundException {
		StudentDeveloperCourse studentDeveloperCourse = studentDeveloperCourseMapper
				.transformToEntity(studentDeveloperCourseDTO);
		Integer studentId = studentDeveloperCourseDTO.getStudentId();
		Integer courseId = studentDeveloperCourseDTO.getDeveloperCourseId();
		Optional<Student> student = studentRepository.findById(studentId);
		Optional<DeveloperCourse> developerCourse = developerCourseRepository.findById(courseId);
		if (!student.isPresent()) {
			throw new ResourceNotFoundException(studentId.toString(), "Student not found.");
		}
		if (!developerCourse.isPresent()) {
			throw new ResourceNotFoundException(courseId.toString(), "Developer course not found.");
		}
		if (studentDeveloperCourseRepository.findByDeveloperCourseIdAndStudentId(courseId, studentId).isPresent()) {
			throw new RequestDataException("Student course combination is already present.");
		}
		return studentDeveloperCourseMapper
				.transformToDTO(studentDeveloperCourseRepository.save(studentDeveloperCourse));
	}

	@Override
	public void remove(Integer id) throws ResourceNotFoundException {
		Optional<StudentDeveloperCourse> studentDeveloperCourse = studentDeveloperCourseRepository.findById(id);
		if (!studentDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Student developer course not found.");
		}
		studentDeveloperCourseRepository.deleteById(id);
	}

	@Override
	public StudentDeveloperCourseDTO update(Integer id, StudentDeveloperCourseDTO studentDeveloperCourseDTO)
			throws ResourceNotFoundException {
		Optional<StudentDeveloperCourse> oldStudentDeveloperCourse = studentDeveloperCourseRepository.findById(id);
		if (!oldStudentDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Student developer course not found.");
		}
		oldStudentDeveloperCourse.get().setDeveloperCourseId(studentDeveloperCourseDTO.getDeveloperCourseId());
		oldStudentDeveloperCourse.get().setStudentId(studentDeveloperCourseDTO.getStudentId());
		oldStudentDeveloperCourse.get().setClassesBought(studentDeveloperCourseDTO.getClassesBought());
		studentDeveloperCourseRepository.save(oldStudentDeveloperCourse.get());
		return studentDeveloperCourseMapper.transformToDTO(oldStudentDeveloperCourse.get());
	}

	@Override
	public List<StudentDeveloperCourseDTO> findByStudentId(Integer studentId) throws ResourceNotFoundException {
		Optional<List<StudentDeveloperCourse>> studentDeveloperCourse = studentDeveloperCourseRepository
				.findByStudentId(studentId);
		if (!studentDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(studentId.toString(), "Student not found.");
		}
		return studentDeveloperCourseMapper.transformToListOfDTO(studentDeveloperCourse.get());
	}

	@Override
	public List<StudentDeveloperCourseDTO> findByDeveloperCourseId(Integer developerCourseId)
			throws ResourceNotFoundException {
		Optional<List<StudentDeveloperCourse>> studentDeveloperCourse = studentDeveloperCourseRepository
				.findByDeveloperCourseId(developerCourseId);
		if (!studentDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(developerCourseId.toString(), "Developer course not found.");
		}
		return studentDeveloperCourseMapper.transformToListOfDTO(studentDeveloperCourse.get());
	}

	@Override
	public void deleteStudentsByDeveloperCourseId(Integer developerCourseId) throws ResourceNotFoundException {
		Optional<DeveloperCourse> opt = developerCourseRepository.findById(developerCourseId);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException(developerCourseId.toString(), "Developer course not found.");
		}
		studentDeveloperCourseRepository.deleteStudentsByDeveloperCourseId(developerCourseId);
	}

	@Override
	public void deleteStudentDeveloperCoursesByStudentId(Integer studentId) throws ResourceNotFoundException {
		Optional<Student> opt = studentRepository.findById(studentId);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException(studentId.toString(), "Student not found.");
		}
		studentDeveloperCourseRepository.deleteStudentDeveloperCoursesByStudentId(studentId);
	}
}
