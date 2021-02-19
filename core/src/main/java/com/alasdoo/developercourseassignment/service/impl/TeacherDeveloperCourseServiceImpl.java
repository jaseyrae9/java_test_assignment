package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdoo.developercourseassignment.dto.TeacherDeveloperCourseDTO;
import com.alasdoo.developercourseassignment.entity.DeveloperCourse;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.entity.TeacherDeveloperCourse;
import com.alasdoo.developercourseassignment.exceptions.RequestDataException;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.mapper.TeacherDeveloperCourseMapper;
import com.alasdoo.developercourseassignment.repository.DeveloperCourseRepository;
import com.alasdoo.developercourseassignment.repository.TeacherDeveloperCourseRepository;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherDeveloperCourseService;

@Service
public class TeacherDeveloperCourseServiceImpl implements TeacherDeveloperCourseService {

	@Autowired
	private TeacherDeveloperCourseRepository teacherDeveloperCourseRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private DeveloperCourseRepository developerCourseRepository;

	@Autowired
	private TeacherDeveloperCourseMapper teacherDeveloperCourseMapper;

	@Override
	public TeacherDeveloperCourseDTO findOne(Integer id) throws ResourceNotFoundException {
		Optional<TeacherDeveloperCourse> teacherDeveloperCourse = teacherDeveloperCourseRepository.findById(id);
		if (!teacherDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Teacher deveoper course not found.");
		}
		return teacherDeveloperCourseMapper.transformToDTO(teacherDeveloperCourse.get());
	}

	@Override
	public List<TeacherDeveloperCourseDTO> findAll() {
		return teacherDeveloperCourseRepository.findAll().stream()
				.map(i -> teacherDeveloperCourseMapper.transformToDTO(i)).collect(Collectors.toList());
	}

	@Override
	public TeacherDeveloperCourseDTO save(TeacherDeveloperCourseDTO teacherDeveloperCourseDTO)
			throws ResourceNotFoundException, RequestDataException {
		TeacherDeveloperCourse teacherDeveloperCourse = teacherDeveloperCourseMapper
				.transformToEntity(teacherDeveloperCourseDTO);
		Integer teacherId = teacherDeveloperCourseDTO.getTeacherId();
		Integer courseId = teacherDeveloperCourseDTO.getDeveloperCourseId();
		Optional<Teacher> teacher = teacherRepository.findById(teacherId);
		Optional<DeveloperCourse> developerCourse = developerCourseRepository.findById(courseId);
		if (!teacher.isPresent()) {
			throw new ResourceNotFoundException(teacherId.toString(), "Teacher not found.");
		}
		if (!developerCourse.isPresent()) {
			throw new ResourceNotFoundException(courseId.toString(), "Developer course not found.");
		}
		if (teacherDeveloperCourseRepository.findByDeveloperCourseIdAndTeacherId(courseId, teacherId).isPresent()) {
			throw new RequestDataException("Teacher developer course combination is already present.");
		}
		return teacherDeveloperCourseMapper
				.transformToDTO(teacherDeveloperCourseRepository.save(teacherDeveloperCourse));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException, ResourceNotFoundException {
		Optional<TeacherDeveloperCourse> teacherDeveloperCourse = teacherDeveloperCourseRepository.findById(id);
		if (!teacherDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Teacher deveoper course not found.");
		}
		teacherDeveloperCourseRepository.deleteById(id);
	}

	@Override
	public TeacherDeveloperCourseDTO update(Integer id, TeacherDeveloperCourseDTO teacherDeveloperCourseDTO)
			throws ResourceNotFoundException {
		Optional<TeacherDeveloperCourse> oldTeacherDeveloperCourse = teacherDeveloperCourseRepository.findById(id);
		if (!oldTeacherDeveloperCourse.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Teacher deveoper course not found.");
		}
		oldTeacherDeveloperCourse.get().setDeveloperCourseId(teacherDeveloperCourseDTO.getDeveloperCourseId());
		oldTeacherDeveloperCourse.get().setTeacherId(teacherDeveloperCourseDTO.getTeacherId());
		teacherDeveloperCourseRepository.save(oldTeacherDeveloperCourse.get());
		return teacherDeveloperCourseMapper.transformToDTO(oldTeacherDeveloperCourse.get());
	}

	@Override
	public List<TeacherDeveloperCourseDTO> findByTeacherId(Integer teacherId) throws ResourceNotFoundException {
		Optional<Teacher> opt = teacherRepository.findById(teacherId);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException(teacherId.toString(), "Teacher not found");
		}
		List<TeacherDeveloperCourse> teacherDeveloperCourse = teacherDeveloperCourseRepository
				.findByTeacherId(teacherId);
		return teacherDeveloperCourseMapper.transformToListOfDTO(teacherDeveloperCourse);
	}

	@Override
	public List<TeacherDeveloperCourseDTO> findByDeveloperCourseId(Integer developerCourseId)
			throws ResourceNotFoundException {
		Optional<DeveloperCourse> opt = developerCourseRepository.findById(developerCourseId);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException(developerCourseId.toString(), "Developer course not found");
		}
		List<TeacherDeveloperCourse> teacherDeveloperCourse = teacherDeveloperCourseRepository
				.findByDeveloperCourseId(developerCourseId);
		return teacherDeveloperCourseMapper.transformToListOfDTO(teacherDeveloperCourse);
	}

	@Override
	public void deleteTeachersByDeveloperCourseId(Integer developerCourseId) throws ResourceNotFoundException {
		Optional<DeveloperCourse> opt = developerCourseRepository.findById(developerCourseId);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException(developerCourseId.toString(), "Developer course not found");
		}
		teacherDeveloperCourseRepository.deleteTeachersByDeveloperCourseId(developerCourseId);
	}

	@Override
	public void deleteTeacherDeveloperCourseByTeacherId(Integer teacherId) throws ResourceNotFoundException {
		Optional<Teacher> opt = teacherRepository.findById(teacherId);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException(teacherId.toString(), "Teacher not found");
		}
		teacherDeveloperCourseRepository.deleteTeacherDeveloperCoursesByTeacherId(teacherId);
	}

}
