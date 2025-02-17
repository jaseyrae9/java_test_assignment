package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.exceptions.ResourceNotFoundException;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private TeacherDeveloperCourseServiceImpl teacherDeveloperCourseServiceImpl;

	@Override
	public TeacherDTO findOne(Integer id) throws ResourceNotFoundException {
		Optional<Teacher> teacher = teacherRepository.findById(id);
		if (!teacher.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Teacher not found.");
		}
		return teacherMapper.transformToDTO(teacher.get());
	}

	@Override
	public List<TeacherDTO> findAll() {
		return teacherRepository.findAll().stream().map(t -> teacherMapper.transformToDTO(t))
				.collect(Collectors.toList());
	}

	@Override
	public TeacherDTO save(TeacherDTO teacherDTO) {
		Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
		return teacherMapper.transformToDTO(teacherRepository.save(teacher));
	}

	@Transactional
	@Override
	public void remove(Integer id) throws ResourceNotFoundException {
		Optional<Teacher> teacher = teacherRepository.findById(id);
		if (!teacher.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Teacher not found.");
		}

		teacherDeveloperCourseServiceImpl.deleteTeacherDeveloperCourseByTeacherId(id); // deleting many to many
																						// relationship
		teacherRepository.deleteById(id);
	}

	@Override
	public TeacherDTO update(Integer id, TeacherDTO teacherDTO) throws ResourceNotFoundException {
		Optional<Teacher> oldTeacherOpt = teacherRepository.findById(id);
		if (!oldTeacherOpt.isPresent()) {
			throw new ResourceNotFoundException(id.toString(), "Teacher not found.");
		}
		Teacher oldTeacher = oldTeacherOpt.get();
		oldTeacher.setTeacherName(teacherDTO.getTeacherName());
		oldTeacher.setTeacherSurname(teacherDTO.getTeacherSurname());
		oldTeacher.setTeacherEmail(teacherDTO.getTeacherEmail());
		teacherRepository.save(oldTeacher);
		return teacherMapper.transformToDTO(oldTeacher);
	}

	@Override
	public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) throws ResourceNotFoundException {
		Optional<Teacher> teacher = teacherRepository.findByTeacherNameAndTeacherSurname(name, surname);
		if (!teacher.isPresent()) {
			throw new ResourceNotFoundException(name + " " + surname, "Teacher not found.");
		}
		return teacherMapper.transformToDTO(teacher.get());
	}

	@Override
	public TeacherDTO findByTeacherEmail(String email) throws ResourceNotFoundException {
		Optional<Teacher> teacher = teacherRepository.findByTeacherEmail(email);
		if (!teacher.isPresent()) {
			throw new ResourceNotFoundException(email, "Teacher not found.");
		}
		return teacherMapper.transformToDTO(teacher.get());
	}
}
